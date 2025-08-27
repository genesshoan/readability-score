# Readability Score Calculator

Un calculador de puntuación de legibilidad implementado en Java como parte del proyecto **Readability Score (Java)** de [Hyperskill](https://hyperskill.org/projects/39).

## 📖 Descripción

Este proyecto implementa un analizador de texto que calcula la puntuación de legibilidad utilizando la **fórmula de Flesch-Kincaid**. El programa analiza un archivo de texto y determina qué tan fácil es de leer, proporcionando también el rango de edad recomendado para comprenderlo.

### ¿Qué es la legibilidad?

La legibilidad es la facilidad con la que un lector puede entender un texto escrito. Este proyecto utiliza la fórmula de Flesch-Kincaid que considera:
- Número de caracteres por palabra
- Número de palabras por oración
- Complejidad general del texto

## 🔧 Características

- ✅ Análisis de archivos de texto (.txt)
- ✅ Cálculo automático de:
  - Número de palabras
  - Número de oraciones
  - Número de caracteres (sin espacios)
- ✅ Puntuación de legibilidad usando Flesch-Kincaid
- ✅ Rango de edad recomendado para la comprensión del texto
- ✅ Uso de expresiones regulares (regex) para el análisis

## 📋 Requisitos

- Java 8 o superior
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
Readability is the ease with which a reader can understand a written text...

Words: 108
Sentences: 6
Characters: 580
The score is: 12.86
This text should be understood by 16-17 year-olds.
```

## 🧮 Fórmula Utilizada

**Flesch-Kincaid Grade Level:**
```
Score = 4.71 × (caracteres/palabras) + 0.5 × (palabras/oraciones) - 21.43
```

### Interpretación del Score

| Score | Edad Recomendada | Nivel de Lectura |
|-------|------------------|------------------|
| 0-4   | 4-9 años        | Muy fácil        |
| 5-9   | 9-14 años       | Fácil            |
| 10-13 | 14-18 años      | Moderado         |
| 14+   | 18+ años        | Difícil          |

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
- `calculateScore()` - Aplica la fórmula Flesch-Kincaid
- `getAge()` - Convierte score a rango de edad

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **Regex**: Para análisis y parsing del texto
- **Java NIO**: Para lectura de archivos
- **Streams API**: Para procesamiento funcional

## 📝 Ejemplo de Archivo de Entrada

Crea un archivo `.txt` con cualquier texto en inglés:

```txt
Readability is the ease with which a reader can understand a written text. 
In natural language, the readability of text depends on its content and its presentation.
```

## 🎯 Objetivos de Aprendizaje (Hyperskill)

Este proyecto ayuda a practicar:
- Manipulación de strings en Java
- Expresiones regulares (regex)
- Lectura de archivos
- Operaciones matemáticas
- Estructuración de código en métodos

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
