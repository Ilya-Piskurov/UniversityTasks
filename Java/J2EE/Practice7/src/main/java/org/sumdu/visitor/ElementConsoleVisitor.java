package org.sumdu.visitor;

import org.sumdu.Character;
import org.sumdu.classes.CharacterClass;
import org.sumdu.race.CharacterRace;
import org.sumdu.states.Stats;

public class ElementConsoleVisitor implements DataElementVisitor {
    @Override
    public void visit(Character character) {
        System.out.println("Character's Name: " + character.getName());
    }

    @Override
    public void visit(Stats stats) {
        stats.writeStats();
    }

    @Override
    public void visit(CharacterRace characterRace) {
        System.out.println("Character's Race: " + characterRace.getName());
        System.out.println("Bonuses: ");
        characterRace.getBonuses().writeStats();
    }

    @Override
    public void visit(CharacterClass characterClass) {
        System.out.println("Character's Class: " + characterClass.getName());
        System.out.println("HP: " + characterClass.getHp());
    }
}
