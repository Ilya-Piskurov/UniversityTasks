// Програма, що вирішує завдання 16-20 по предмету ООП мовою Java.
// Документацію дивиться в інших класах :>

/*
 * Інформаційна шапка:
 * Автор: Піскурьов Ілля Віталійович (ІН-01).
 * Назва дисципліни: ООП на мові Java.
 * Кінцевий термін подання: 30 вересня
 * Часу витрачено: 2.5 години.
 * Я підтверджу, що це моя власна робота!
 */

package com.sumdu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var rChecker = new RhombusChecker();
        var in = new Scanner(System.in);

        String answer;
        do {
            rChecker.readInput();
            System.out.println("\n------------------------------");
            if (rChecker.isRhombus()) {
                System.out.println("Вауу, це дійсно Ромб!");
            } else {
                System.out.println("На жаль, це не Ромб :<");
            }
            // Питаємо користувача чи хоче він спробувати знову.
            System.out.print("Чи бажаєте ви продовжити? (yes - так, все інше - ні): ");
            answer = in.next();
        } while (answer.equals("yes"));
    }
}