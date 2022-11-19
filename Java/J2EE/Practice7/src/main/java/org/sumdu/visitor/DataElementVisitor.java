package org.sumdu.visitor;

import org.sumdu.Character;
import org.sumdu.classes.CharacterClass;
import org.sumdu.race.CharacterRace;
import org.sumdu.states.Stats;

public interface DataElementVisitor {
    void visit(Character character);
    void visit(Stats stats);
    void visit(CharacterRace characterRace);
    void visit(CharacterClass characterClass);
}
