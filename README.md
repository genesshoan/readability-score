# Readability Score Calculator

Un calculador de puntuación de legibilidad implementado en Java como parte del proyecto **Readability Score (Java)** de [Hyperskill](https://hyperskill.org/projects/39).

## 📖 Descripción

Este proyecto implementa un analizador de texto que calcula la puntuación de legibilidad utilizando **cuatro métodos diferentes**:
- **ARI (Automated Readability Index)**
- **FK (Flesch-Kincaid Grade Level)**
- **SMOG (Simple Measure of Gobbledygook)**
- **CL (Coleman-Liau Index)**

El programa analiza un archivo de texto y determina qué tan fácil es de leer, proporcionando también el rango de edad recomendado para comprenderlo.

### ¿Qué es la legibilidad?

La legibilidad es la facilidad con la que un lector puede entender un texto escrito. Este proyecto utiliza múltiples fórmulas que consideran:
- Número de caracteres por palabra
- Número de palabras por oración
- Número de sílabas por palabra
- Número de palabras polisilábicas (más de 2 sílabas)

## 🔧 Características

- ✅ Análisis de archivos de texto (.txt)
- ✅ Cálculo automático de:
  - Número de palabras
  - Número de oraciones
  - Número de caracteres (sin espacios)
  - Número de sílabas
  - Número de palabras polisilábicas
- ✅ **Cuatro métodos de puntuación de legibilidad:**
  - **ARI**: Basado en caracteres y palabras
  - **FK**: Basado en sílabas y longitud de oraciones
  - **SMOG**: Enfocado en palabras polisilábicas
  - **CL**: Combinación de caracteres y oraciones
- ✅ Cálculo del promedio de edad cuando se usan todos los métodos
- ✅ Rango de edad recomendado para cada método
- ✅ Uso de expresiones regulares (regex) para el análisis

## 📋 Requisitos

- Java 11 o superior (usa `switch` expressions)
- Sistema operativo: Windows, macOS o Linux

## 🚀 Instalación y Uso

### 1. Compilación

```bash
javac -d out src/shoangenes/dev/ReadabilityScore.java
```

### 2. Ejecución

```bash
java -cp out shoangenes.dev.ReadabilityScore ruta/al/archivo.txt
```

### Ejemplo de uso

```bash
java -cp out shoangenes.dev.ReadabilityScore src/shoangenes/dev/in.txt
```

## 📊 Ejemplo de Salida

```
The text is:
This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages...

Words: 137
Sentences: 14
Characters: 687
Syllables: 210
Polysyllables: 17
Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all
Automated Readability Index: 7.08 (about 13-year-olds).
Flesch–Kincaid readability tests: 6.31 (about 12-year-olds).
Simple Measure of Gobbledygook: 9.42 (about 15-year-olds).
Coleman–Liau index: 10.66 (about 17-year-olds).

This text should be understood in average by 14.25-year-olds.
```

## 🧮 Fórmulas Utilizadas

### 1. ARI (Automated Readability Index)
```
Score = 4.71 × (caracteres/palabras) + 0.5 × (palabras/oraciones) - 21.43
```

### 2. Flesch-Kincaid Grade Level
```
Score = 0.39 × (palabras/oraciones) + 11.8 × (sílabas/palabras) - 15.59
```

### 3. SMOG (Simple Measure of Gobbledygook)
```
Score = 1.043 × √(polisilábicas × (30/oraciones)) + 3.1291
```

### 4. Coleman-Liau Index
```
Score = 0.0588 × L - 0.296 × S - 15.8
Donde: L = caracteres por 100 palabras, S = oraciones por 100 palabras
```

### Interpretación del Score

| Score | Edad Recomendada | Nivel de Lectura |
|-------|------------------|------------------|
| 1-6   | 6-11 años       | Muy fácil        |
| 7-9   | 12-14 años      | Fácil            |
| 10-12 | 15-17 años      | Moderado         |
| 13-14 | 18-22 años      | Difícil          |
| 15+   | 24+ años        | Muy difícil      |

## 🔍 Estructura del Código

```
src/
└── shoangenes/
    └── dev/
        ├── ReadabilityScore.java  # Clase principal
        └── in.txt                 # Archivo de prueba
```

### Métodos principales:

- `howManyCharacters()` - Cuenta caracteres sin espacios
- `howManyWords()` - Cuenta palabras usando regex
- `howManySentences()` - Cuenta oraciones por puntos, exclamaciones y interrogaciones
- `countSyllables()` - Cuenta sílabas en una palabra
- `howManySyllables()` - Cuenta sílabas totales del texto
- `howManyPolysyllables()` - Cuenta palabras con más de 2 sílabas
- `calculateScoreByARI()` - Calcula ARI
- `calculateScoreByFK()` - Calcula Flesch-Kincaid
- `calculateScoreBySMOG()` - Calcula SMOG
- `calculateScoreByCL()` - Calcula Coleman-Liau
- `getAge()` - Convierte score a rango de edad

## 💻 Opciones de Cálculo

El programa permite elegir qué método usar:
- `ari` - Solo Automated Readability Index
- `fk` - Solo Flesch-Kincaid
- `smog` - Solo SMOG
- `cl` - Solo Coleman-Liau
- `all` - Todos los métodos + promedio de edad

## 🛠️ Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación principal (switch expressions)
- **Regex**: Para análisis y parsing del texto
- **Java NIO**: Para lectura de archivos
- **Streams API**: Para procesamiento funcional
- **Algoritmos de conteo de sílabas**: Para análisis lingüístico

## 📝 Ejemplo de Archivo de Entrada

Crea un archivo `.txt` con cualquier texto en inglés:

```txt
This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone!
```

## 🎯 Objetivos de Aprendizaje (Hyperskill)

Este proyecto ayuda a practicar:
- Manipulación de strings en Java
- Expresiones regulares (regex) avanzadas
- Lectura de archivos con NIO
- Operaciones matemáticas complejas
- Estructuración de código en métodos
- Switch expressions (Java 11+)
- Algoritmos de análisis de texto
- Conteo de sílabas y análisis lingüístico

## 🤝 Contribuciones

Este es un proyecto educativo de Hyperskill. Si encuentras mejoras o bugs, siéntete libre de:
1. Fork del repositorio
2. Crear una rama para tu feature
3. Commit de tus cambios
4. Push a la rama
5. Crear un Pull Request

## 📜 Licencia

Este proyecto es parte de los ejercicios de [Hyperskill](https://hyperskill.org) y tiene fines educativos.

---

⭐ **¡Dale una estrella si este proyecto te ayudó a aprender!** ⭐
