package org.sumdu;

/**
 *  Клас, в якому інкапсульована логіка перевірки,
 *  чи утворюють точки ромб.
 *  Взаємодіяти таким чином: створити екземпляр, передавши
 *  конструктору масив точок та викликати публічний метод
 *  isRhombus(). Якщо ви хочете спробувати
 *  на нових даних, то викличте сеттер setPoints і потім
 *  знову метод isRhombus().
 */
public class RhombusChecker {

    /**
     * Константа, яка відповідає за те, скільки точок потрібно для перевірки.
     */
    public static final int COUNT_OF_POINTS = 4;

    /**
     * Масив для збереження всіх точок.
     */
    private Point[] points;

    /**
     * Конструктор, що приймає масив точок.
     * @param points - масив точок.
     */
    public RhombusChecker(Point[] points) {
        setPoints(points);
    }

    /**
     * Сеттер масиву точок.
     * @param points - масив точок.
     */
    public void setPoints(Point[] points) {
        this.points = points;
    }

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
