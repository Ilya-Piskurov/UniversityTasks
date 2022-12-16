package org.piskurov.model;

import org.piskurov.model.classes.CharacterClass;
import org.piskurov.model.race.CharacterRace;
import org.piskurov.model.states.Stats;

public class DnDCharacterMemento {

    public String name;
    public CharacterRace characterRace;
    public CharacterClass characterClass;
    public Stats attributes;

    public DnDCharacterMemento(
            String name,
            CharacterRace characterRace,
            CharacterClass characterClass,
            Stats attributes
    ) {
        this.name = name;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.attributes = attributes;
    }
}
