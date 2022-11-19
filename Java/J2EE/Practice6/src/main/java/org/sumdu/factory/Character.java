package org.sumdu.factory;

import org.sumdu.abstractfactory.classes.CharacterClass;
import org.sumdu.abstractfactory.states.Stats;
import org.sumdu.factory.race.CharacterRace;

public class Character {

    private String name;
    private CharacterRace characterRace;
    private Stats attributes;

    public Character(String name, CharacterRace characterRace) {
        this.name = name;
        this.characterRace = characterRace;
        attributes = Stats.generate();
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

    public void talk() {
        System.out.println("Hello, my name is " + name);
        attributes.writeStats();
    }
}
