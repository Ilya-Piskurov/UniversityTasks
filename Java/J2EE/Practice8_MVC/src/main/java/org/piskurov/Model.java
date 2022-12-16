package org.piskurov;

import org.json.JSONObject;
import org.piskurov.model.DnDCharacter;
import org.piskurov.model.DnDCharacterMemento;
import org.piskurov.model.classes.ClassAbstractFactory;
import org.piskurov.model.race.RaceAbstractFactory;

import java.io.FileWriter;
import java.io.IOException;

public class Model {

    private DnDCharacter currentCharacter = null;
    private DnDCharacterMemento memento = null;

    public void generateCharacter(String name, String raceType, String classType) {

        if (currentCharacter != null) {
            memento = currentCharacter.saveState();
        }

        currentCharacter = new DnDCharacter(
                name,
                RaceAbstractFactory.getClass(raceType),
                ClassAbstractFactory.getClass(classType)
        );
    }

    public void revertCharacter() {

        if (memento == null) {
            throw new IllegalArgumentException("Немає попереднього стану!");
        }

        currentCharacter.restoreState(memento);
    }

    public void saveCharacter() throws IOException {

        if (currentCharacter == null) {
            throw new IllegalArgumentException("Персонаж не створений!");
        }

        JSONObject characterObj = new JSONObject();

        characterObj.put("name", currentCharacter.getName());
        characterObj.put("race", currentCharacter.getCharacterRace().getName());
        characterObj.put("class", currentCharacter.getCharacterClass().getName());

        JSONObject attributes = new JSONObject();

        attributes.put("strength", currentCharacter.getAttributes().getStrength());
        attributes.put("dexterity", currentCharacter.getAttributes().getDexterity());
        attributes.put("constitution", currentCharacter.getAttributes().getConstitution());
        attributes.put("intelligence", currentCharacter.getAttributes().getIntelligence());
        attributes.put("wisdom", currentCharacter.getAttributes().getWisdom());
        attributes.put("charisma", currentCharacter.getAttributes().getCharisma());

        characterObj.put("attributes", attributes);

        try {
            FileWriter file = new FileWriter("character.json");
            file.write(characterObj.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public DnDCharacter getCurrentCharacter() {
        return currentCharacter;
    }
}
