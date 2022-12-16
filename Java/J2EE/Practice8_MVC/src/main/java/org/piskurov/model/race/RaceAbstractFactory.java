package org.piskurov.model.race;

public class RaceAbstractFactory {
    public static CharacterRace getClass(String type){
        return switch (type) {
            case "Dwarf" -> new Dwarf();
            case "Human" -> new Human();
            default -> throw new IllegalArgumentException("Can`t find this type of race: " + type);
        };
    }
}
