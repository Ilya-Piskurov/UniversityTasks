package org.sumdu.factory.race;

import org.sumdu.factory.states.Stats;

public class Dwarf extends CharacterRace {

    public Dwarf() {
        name = "Dwarf";
        bonuses = new Stats(2,0,0,1,0, 0);
    }

    public String getName() {
        return name;
    }

    public Stats getBonuses() {
        return bonuses;
    }

    @Override
    public void saySMTH() {
        System.out.println("AAAAAA!");
    }
}
