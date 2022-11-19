package org.sumdu.visitor;

import org.sumdu.Character;
import org.sumdu.classes.CharacterClass;
import org.sumdu.race.CharacterRace;
import org.sumdu.states.Stats;

import java.util.HashMap;

public class ElementSaverVisitor implements DataElementVisitor {

    private final HashMap<String, String> hashMap = new HashMap<>();

    @Override
    public void visit(Character character) {
        hashMap.put("Character's Name", character.getName());
    }

    @Override
    public void visit(Stats stats) {
        hashMap.put("Strength", String.valueOf(stats.getStrength()));
        hashMap.put("Constitution", String.valueOf(stats.getConstitution()));
        hashMap.put("Charisma", String.valueOf(stats.getCharisma()));
        hashMap.put("Intelligence", String.valueOf(stats.getIntelligence()));
        hashMap.put("Dexterity", String.valueOf(stats.getDexterity()));
        hashMap.put("Wisdom", String.valueOf(stats.getWisdom()));
    }

    @Override
    public void visit(CharacterRace characterRace) {
        Stats stats = characterRace.getBonuses();
        hashMap.put("Character's Race", characterRace.getName());
        hashMap.put("Strength", String.valueOf(stats.getStrength()));
        hashMap.put("Constitution", String.valueOf(stats.getConstitution()));
        hashMap.put("Charisma", String.valueOf(stats.getCharisma()));
        hashMap.put("Intelligence", String.valueOf(stats.getIntelligence()));
        hashMap.put("Dexterity", String.valueOf(stats.getDexterity()));
        hashMap.put("Wisdom", String.valueOf(stats.getWisdom()));
    }

    @Override
    public void visit(CharacterClass characterClass) {
        hashMap.put("Character's Class", characterClass.getName());
        hashMap.put("HP", String.valueOf(characterClass.getHp()));
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }
}
