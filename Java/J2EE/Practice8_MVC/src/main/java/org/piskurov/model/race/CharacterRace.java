package org.piskurov.model.race;

import org.piskurov.model.states.Stats;

public abstract class CharacterRace {
    private String name;
    private Stats bonuses;

    public String getName() {
        return name;
    }

    public Stats getBonuses() {
        return bonuses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBonuses(Stats bonuses) {
        this.bonuses = bonuses;
    }
}
