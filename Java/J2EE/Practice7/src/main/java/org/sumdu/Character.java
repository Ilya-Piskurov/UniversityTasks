package org.sumdu;

import org.sumdu.classes.CharacterClass;
import org.sumdu.race.CharacterRace;
import org.sumdu.states.Stats;
import org.sumdu.visitor.DataElement;
import org.sumdu.visitor.DataElementVisitor;
import org.sumdu.visitor.ElementSaverVisitor;

public class Character implements DataElement {

    private String name;
    private CharacterRace  characterRace;
    private CharacterClass characterClass;
    private Stats attributes;

    public Character(String name, CharacterRace characterRace, CharacterClass characterClass) {
        this.name = name;
        this.characterRace  = characterRace;
        this.characterClass = characterClass;
        attributes = Stats.generate();
        addRaceBonus();
    }

    public void addRaceBonus() {
        Stats raceBonuses = characterRace.getBonuses();
        attributes.setStrength(attributes.getStrength() + raceBonuses.getStrength());
        attributes.setCharisma(attributes.getCharisma() + raceBonuses.getCharisma());
        attributes.setConstitution(attributes.getConstitution() + raceBonuses.getConstitution());
        attributes.setIntelligence(attributes.getIntelligence() + raceBonuses.getIntelligence());
        attributes.setWisdom(attributes.getWisdom() + raceBonuses.getWisdom());
        attributes.setDexterity(attributes.getDexterity() + raceBonuses.getDexterity());
    }

    public void talk() {
        System.out.println("Hello, my name is " + name);
        System.out.println("I have some skills:");
        characterClass.printMagika();
        attributes.writeStats();
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

    @Override
    public void acceptOperation(DataElementVisitor visitor) {
        visitor.visit(this);
    }
}
