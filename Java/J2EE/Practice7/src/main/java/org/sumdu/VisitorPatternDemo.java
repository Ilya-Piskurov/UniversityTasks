package org.sumdu;

import org.sumdu.classes.Barbarian;
import org.sumdu.json.JsonSaver;
import org.sumdu.race.Dwarf;
import org.sumdu.visitor.DataElementVisitor;
import org.sumdu.visitor.ElementConsoleVisitor;
import org.sumdu.visitor.ElementSaverVisitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        Character character = new Character("Danil", new Dwarf(), new Barbarian());

        ElementSaverVisitor saver = new ElementSaverVisitor();

        character.acceptOperation(saver);
        character.getCharacterRace().acceptOperation(saver);
        character.getCharacterClass().acceptOperation(saver);
        character.getAttributes().acceptOperation(saver);

        var treeMap = saver.getHashMap();

        DataElementVisitor dataElementVisitor = new ElementConsoleVisitor();
        character.acceptOperation(dataElementVisitor);
        character.getCharacterRace().acceptOperation(dataElementVisitor);
        character.getCharacterClass().acceptOperation(dataElementVisitor);
        character.getAttributes().acceptOperation(dataElementVisitor);

        JsonSaver jsonSaver = new JsonSaver();
        jsonSaver.write("./src/main/resources/test.json", treeMap);
    }
}
