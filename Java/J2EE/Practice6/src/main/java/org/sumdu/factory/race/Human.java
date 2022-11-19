package org.sumdu.factory.race;

import org.sumdu.factory.states.Stats;

public class Human extends CharacterRace {

    public Human() {
        name = "Human";
        bonuses = new Stats(1,0,0,3,1, 1);
    }

    public String getName() {
        return name;
    }

    public Stats getBonuses() {
        return bonuses;
    }

    @Override
    public void saySMTH() {
        System.out.println("Hello!");
    }
}
