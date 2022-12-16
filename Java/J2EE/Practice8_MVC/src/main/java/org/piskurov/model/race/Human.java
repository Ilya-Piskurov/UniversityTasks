package org.piskurov.model.race;

import org.piskurov.model.states.Stats;

public class Human extends CharacterRace {
    public Human() {
        setName("Human");
        setBonuses(new Stats(1,0,0,3,1, 1));
    }
}
