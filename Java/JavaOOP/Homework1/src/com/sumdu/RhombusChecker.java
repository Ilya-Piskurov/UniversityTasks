package com.sumdu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Клас, в якому інкапсульована основна логіка програми,
 *  тобто зчитування точок і перевірка чи утворюють вони прямокутник.
 *  Взаємодіяти таким чином: створити екземпляр, заповнити дані та
 *  викликати публічний метод isRhombus(). Якщо ви хочете спробувати
 *  на нових даних, то викличте публічний метод readInput() і потім
 *  isRhombus().
 */
public class RhombusChecker {

    /**
     * Константа, яка відповідає за те, скільки точок ми запитуємо у користувача.
     */
    private static final int COUNT_OF_POINTS = 4;

    /**
     * Об'єкт для зчитування вводу від користувача. Визначений як поле класу, тому що
     * маємо декілько методов які будуть запрашувати ввод.
     */
    private final Scanner in = new Scanner(System.in);
    /**
     * Масив для збереження всіх точок.
     */
    private final Point[] points = new Point[COUNT_OF_POINTS];

    /**
     * Пустий конструктор.
     */
    public RhombusChecker() {}

    /**
     * Метод, що відповідає на питання чи утворюють введені точки ромб.
     * @return - true, якщо точки утворюють ромб, інакше - false.
     */
    public boolean isRhombus() {

        // Рахуємо довжини сторін
        double section1 = lengthSection(points[0], points[1]);
        double section2 = lengthSection(points[1], points[2]);
        double section3 = lengthSection(points[2], points[3]);
        double section4 = lengthSection(points[3], points[0]);

        // Разуємо довжини діагоналей
        double diagonal1 = lengthSection(points[0], points[2]);
        double diagonal2 = lengthSection(points[1], points[3]);

        // Якщо всі сторони рівні та діагоналі не нульові, то це ромб.
        return section1 == section2 &&
               section1 == section3 &&
               section1 == section4 &&
               diagonal1 > 0 &&
               diagonal2 > 0;
    }

    /**
     * Метод для зчитування всіх точок.
     */
    public void readInput() {
        System.out.println("Вітаю! Я можу перевірити по точкам чи є фігура ромбом :>");
        for (int i = 0; i < COUNT_OF_POINTS; i++) {
            System.out.println("\nПросимо ввести точку №" + (i + 1) + ":");
            double x = readDouble("Точка X: "),
                   y = readDouble("Точка Y: ");
            points[i] = new Point(x, y);
        }
    }

    /**
     * Метод для зчитування числа з плаваючею комою, який обробляє можливу
     * помилку, якщо користувач введе не число.
     * @param invitation - Запрошення до вводу (String)
     * @return - Прочитане число (Double)
     */
    private double readDouble(String invitation) {
        double d;

        while (true) {
            try {
                System.out.print(invitation);
                d = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Єй, ти ввів не число! Тому спробуй ще раз:");
                in.next();
            }
        }

        return d;
    }

    /**
     * Метод, що повертає довжину відрізку. На вхід приймає дві точки.
     * @param a - Перша точка (клас Point)
     * @param b - Друга точка (клас Point)
     * @return - Довжина відрізка (Double)
     */
    private double lengthSection(Point a, Point b) {
        return Math.sqrt(
                Math.pow(b.getX() - a.getX(), 2) +
                Math.pow(b.getY() - a.getY(), 2)
        );
    }
}
