package org.piskurov.model.race;

import org.piskurov.model.states.Stats;

public class Dwarf extends CharacterRace {
    public Dwarf() {
        setName("Dwarf");
        setBonuses(new Stats(2,0,0,1,0, 0));
    }
}
