package org.piskurov.model;

import org.piskurov.model.classes.CharacterClass;
import org.piskurov.model.race.CharacterRace;
import org.piskurov.model.states.Stats;

public class DnDCharacter {

    private String name;
    private CharacterRace characterRace;
    private CharacterClass characterClass;
    private Stats attributes;

    public DnDCharacter(
            String name,
            CharacterRace characterRace,
            CharacterClass characterClass
    ) {
        this.name = name;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        attributes = Stats.generate();
        addRaceBonus();
    }

    public void addRaceBonus() {
        var raceBonuses = characterRace.getBonuses();
        attributes.setStrength(attributes.getStrength() + raceBonuses.getStrength());
        attributes.setCharisma(attributes.getCharisma() + raceBonuses.getCharisma());
        attributes.setConstitution(attributes.getConstitution() + raceBonuses.getConstitution());
        attributes.setIntelligence(attributes.getIntelligence() + raceBonuses.getIntelligence());
        attributes.setWisdom(attributes.getWisdom() + raceBonuses.getWisdom());
        attributes.setDexterity(attributes.getDexterity() + raceBonuses.getDexterity());
    }

    public DnDCharacterMemento saveState() {
        return new DnDCharacterMemento(name, characterRace, characterClass, attributes);
    }

    public void restoreState(DnDCharacterMemento memento) {
        name = memento.name;
        characterRace = memento.characterRace;
        characterClass = memento.characterClass;
        attributes = memento.attributes;
    }

    public String getName() {
        return name;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public Stats getAttributes() {
        return attributes;
    }
}
