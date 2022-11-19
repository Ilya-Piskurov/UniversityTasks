package org.sumdu.abstractfactory;

import org.sumdu.abstractfactory.classes.Barbarian;
import org.sumdu.abstractfactory.classes.Bard;
import org.sumdu.abstractfactory.classes.CharacterClass;

public class ClassAbstractFactory {
    public static CharacterClass getClass(String type){
        return switch (type) {
            case "Bard" -> new Bard();
            case "Barbarian" -> new Barbarian();
            default -> throw new IllegalArgumentException("Can`t find this type of class: " + type);
        };
    }
}