package org.sumdu.abstractfactory.classes;

public class Bard extends CharacterClass {

    public Bard() {
        name = "Bard";
        hp = 10;
        magika = "«Charm Person»,«Heroism»";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Bard{" +
                "name='" + name + '\'' +
                ", magika='" + magika + '\'' +
                ", hp=" + hp +
                '}';
    }
}
