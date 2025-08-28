package shoangenes.dev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadabilityScore {
    private static int howManyCharacters(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    private static List<String> getWords(String text) {
        return List.of(text.replaceAll("[\\W_]+", " ")
                .split("\\s+"));
    }

    private static int howManyWords(String text) {
        return getWords(text).size();
    }

    private static int howManySentences(String text) {
        return (int) Arrays.stream(text.split("[.!?]+"))
                .filter(s -> !s.trim().isEmpty())
                .count();
    }

    private static int  countSyllables(String word) {
        word = word.trim().toLowerCase();

        word = word.replaceAll("[aeiouy]{2,}", "a");

        word = word.replaceAll("(?<!l)e$", "");

        int wordSyllables = word.replaceAll("[^aeiouy]", "").length();

        return (wordSyllables == 0) ? 1 : wordSyllables;
    }

    private static int howManySyllables(String text) {
        List<String> words = getWords(text);

        int syllables = 0;

        for (String w : words) {
            syllables += countSyllables(w);
        }

        return syllables;
    }

    private static int howManyPolysyllables(String text) {
        return (int) getWords(text).stream().filter(w -> countSyllables(w) > 2).count();
    }

    private static double calculateScoreByFK(int words, int sentences, int syllables) {
        if (words == 0 ||  sentences == 0) {
            return 0;
        }

        return 0.39 * ((double) words / sentences) + 11.8 * ((double) syllables / words) - 11.59;
    }

    private static double calculateScoreBySMOG(int polysyllables, int sentences) {
        return sentences == 0 ? 0 : 1.043 * Math.sqrt(polysyllables * ((double)30 / sentences)) + 3.1291;
    }

    private static double calculateScoreByCL(int characters, int words, int sentences) {
        if (words != 0) {
            double l = (double) characters / words * 100;
            double s = (double) sentences / words * 100;

            return 0.0588 * l - 0.296 * s - 15.8;
        }
        return 0;
    }

    private static double calculateScoreByARI(int words, int sentences, int characters) {
        if (words == 0 ||  sentences == 0) {
            return 0;
        }

        return 4.71 * ((double) characters / words) + 0.5 * ((double) words/sentences) - 21.43;
    }

    private static int getAge(int score) {
        if (score == 14) {
            return  22;
        }
        return score + 5;
    }

    private static void printResult(String text, double score) {
        System.out.printf("%s %.2f (about %d-year-olds)\n", text, score, getAge((int) score));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path filePath = Path.of(args[0]);
        try {
            String text = Files.readString(filePath);

            int characters = howManyCharacters(text);
            int words = howManyWords(text);
            int sentences = howManySentences(text);
            int syllables = howManySyllables(text);
            int polysyllables = howManyPolysyllables(text);

            System.out.println("The text is:\n" + text);
            System.out.println("Words: " + words);
            System.out.println("Sentences: " + sentences);
            System.out.println("Characters: " + characters);
            System.out.println("Syllables: " + syllables);
            System.out.println("Polysyllables: " + polysyllables);

            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            String input = sc.nextLine().trim().toLowerCase();

            switch (input) {
                case "all" -> {
                    printResult("Automated Readability Index:",  calculateScoreByARI(words, sentences, characters));
                    printResult("Flesch–Kincaid readability tests:", calculateScoreByFK(words, sentences, syllables));
                    printResult("Simple Measure of Gobbledygook:",  calculateScoreBySMOG(polysyllables, sentences));
                    printResult("Coleman–Liau index:", calculateScoreByCL(characters, words, sentences));
                }
                case "ari" -> printResult("Automated Readability Index:",  calculateScoreByARI(words, sentences, characters));
                case "fk" -> printResult("Flesch–Kincaid readability tests:", calculateScoreByFK(words, sentences, syllables));
                case "smog" -> printResult("Simple Measure of Gobbledygook:",  calculateScoreBySMOG(polysyllables, sentences));
                case "cl" -> printResult("Coleman–Liau index:", calculateScoreByCL(characters, words, sentences));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file: " + args[0]);
        }
        sc.close();
    }
}
