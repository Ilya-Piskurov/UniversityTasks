package org.sumdu.race;

import org.sumdu.states.Stats;
import org.sumdu.visitor.DataElement;

public abstract class CharacterRace implements DataElement {
    protected String name;
    protected Stats bonuses;
    public abstract void saySMTH();

    public abstract String getName();
    public abstract Stats getBonuses();
}
