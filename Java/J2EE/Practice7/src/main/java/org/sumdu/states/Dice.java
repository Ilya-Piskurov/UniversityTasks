package org.sumdu.states;

import java.util.Arrays;

public class Dice {
    private static final int countOfRolls = 6;
    public static int roll() {

        var rolls = new int[countOfRolls];

        for (int i = 0; i < countOfRolls; i++) {
            rolls[i] = (int) (Math.random() * (countOfRolls + 1));
        }

        Arrays.sort(rolls);

        return rolls[3] + rolls[4] + rolls[5];
    }
}
