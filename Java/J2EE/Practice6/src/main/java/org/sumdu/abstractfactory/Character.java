package org.sumdu.abstractfactory;

import org.sumdu.abstractfactory.classes.CharacterClass;
import org.sumdu.abstractfactory.states.Stats;

public class Character {

    private String name;
    private CharacterClass characterClass;
    private Stats attributes;

    public Character(String name, CharacterClass characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        attributes = Stats.generate();
    }

    public void addRaceBonus() {
        attributes.setStrength(attributes.getStrength() + 3);
    }

    public void talk() {
        System.out.println("Hello, my name is " + name);
        System.out.println("I have some skills:");
        characterClass.printMagika();
        attributes.writeStats();
    }
}
