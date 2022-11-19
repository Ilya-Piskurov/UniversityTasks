package org.sumdu.factory.race;

import org.sumdu.factory.states.Stats;

public abstract class CharacterRace {
    protected String name;
    protected Stats bonuses;
    public abstract void saySMTH();

    public abstract String getName();
    public abstract Stats getBonuses();
}
