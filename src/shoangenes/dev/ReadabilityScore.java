package shoangenes.dev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ReadabilityScore {
    private static int howManyCharacters(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    private static int howManyWords(String text) {
        return text.replaceAll("[\\W_]+", " ")
                .split("\\s+")
                .length;
    }

    private static int howManySentences(String text) {
        return (int) Arrays.stream(text.split("[.!?]+"))
                .filter(s -> !s.trim().isEmpty())
                .count();
    }

    private static double calculateScore(int words, int sentences, int characters) {
        if (words == 0 ||  sentences == 0) {
            return 0;
        }

        return 4.71 * ((double) characters / words) + 0.5 * ((double) words/sentences) - 21.43;
    }

    private static int[] getAge(int score) {
        int min = score + 4;
        int max;

        if (score == 14) {
            max = 22;
        } else {
            max = score + 5;
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Path filePath = Path.of(args[0]);
        try {
            String text = Files.readString(filePath);

            int characters = howManyCharacters(text);
            int words = howManyWords(text);
            int sentences = howManySentences(text);
            double score = calculateScore(words, sentences, characters);

            System.out.println("The text is:\n" + text);
            System.out.println("Words: " + words);
            System.out.println("Sentences: " + sentences);
            System.out.println("Characters: " + characters);
            System.out.printf("The score is: %.2f\n", score);
            int[] range = getAge((int)score);
            System.out.println("This text should be understood by " + range[0] + "-" + range[1] + " year-olds.");
        } catch (IOException e) {
            System.out.println("Cannot read file: " + args[0]);
        }
    }
}
