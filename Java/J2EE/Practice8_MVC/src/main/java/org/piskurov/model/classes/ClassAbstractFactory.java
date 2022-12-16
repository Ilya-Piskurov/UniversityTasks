package org.piskurov.model.classes;

public class ClassAbstractFactory {
    public static CharacterClass getClass(String type){
        return switch (type) {
            case "Bard" -> new Bard();
            case "Barbarian" -> new Barbarian();
            default -> throw new IllegalArgumentException("Can`t find this type of class: " + type);
        };
    }
}