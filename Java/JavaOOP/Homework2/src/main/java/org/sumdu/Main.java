/*
 * Інформаційна шапка:
 * Друга домашня робота
 * Автор: Піскурьов Ілля Віталійович (ІН-01).
 * Назва дисципліни: ООП на мові Java.
 * Кінцевий термін подання: 17 жовтня
 * Часу витрачено: 30 хвилин.
 * Опис програми: прочитати координати чотирьох точок з вхідного файлу,
 * проаналзіувати чи створюють вони ромб, і вивести відповідь у
 * вихідних файл.
 * Я підтверджу, що це моя власна робота!
 */

package org.sumdu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас, з якого запускається програма. Має метод для зчитування
 * точок з файлу, а також у методі main за допомогою класу
 * RhombusChecker перевірити чи утворюють вони ромб.
 */
public class Main {

    /**
     * Константа, що зберігає назву вхідного файлу.
     */
    private static final String inputFileName  = "input.txt";
    /**
     * Константа, що зберігає назву вихідного файлу.
     */
    private static final String outputFileName = "output.txt";

    /**
     * Метод, що зчитує точки з файлу.
     * @param filename - Ім'я файлу.
     * @param countOfPoints - Кількість точок, які необхідно зчитати.
     * @return - масив точок
     * @throws FileNotFoundException - може викинути це виключення, якщо файл не буде знайдений.
     */
    public static Point[] readPointsFromFile(String filename, int countOfPoints) throws FileNotFoundException {
        var points = new Point[countOfPoints];
        try {
            var inputFile = new Scanner(new File(filename));
            for (int i = 0; i < countOfPoints; i++) {
                double x = inputFile.nextDouble();
                double y = inputFile.nextDouble();
                points[i] = new Point(x, y);
            }
            return points;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Сорі, не зміг знайти файл з ім'ям: " + filename);
        }
    }

    /**
     * Метод для запису відповідді у вихідний файл.
     * @param filename - Ім'я вихідного файлу.
     * @param answer - Відповідь чи утворюють точки ромб.
     * @throws IOException - це виключення виникає, якщо не вдалося зробити запис у файл.
     */
    public static void writeAnswerToFile(String filename, boolean answer) throws IOException {
        try {
            var outputFile = new FileWriter(filename);
            String answerStr;
            if (answer) {
                answerStr = "Ці точки утворюють ромб :)";
            } else {
                answerStr = "Нажаль ці точки не утворюють ромб :(";
            }
            outputFile.write(answerStr);
            System.out.println(answerStr);
            outputFile.close();
        } catch (IOException e) {
            throw new IOException("Сорі, не можу записати у файл: " + filename);
        }
    }

    /**
     * Вхідна точка у програму.
     * Читає точки з файлу, перевіряє чи вони утворюють ромб,
     * і записує відповідь у файл.
     * @param args - аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            var points = readPointsFromFile(inputFileName, RhombusChecker.COUNT_OF_POINTS);
            var rhombusChecker = new RhombusChecker(points);
            writeAnswerToFile(outputFileName, rhombusChecker.isRhombus());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}