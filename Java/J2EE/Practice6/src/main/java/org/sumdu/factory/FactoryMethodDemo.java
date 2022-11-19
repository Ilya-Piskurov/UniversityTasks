package org.sumdu.factory;

import org.sumdu.factory.factory.DwarfFactory;
import org.sumdu.factory.factory.HumanFactory;
import org.sumdu.factory.factory.RaceAbstractFactory;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        RaceAbstractFactory raceFactory = new DwarfFactory();

        Character ork = new Character("Ork", raceFactory.create());
        ork.talk();

        System.out.print("\n\n===================\n\n");

        raceFactory = new HumanFactory();
        var jsnow = new Character("John Snow", raceFactory.create());
        jsnow.talk();
    }
}
