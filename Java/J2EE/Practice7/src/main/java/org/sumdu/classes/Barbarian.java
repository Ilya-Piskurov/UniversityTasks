package org.sumdu.classes;

import org.sumdu.visitor.DataElementVisitor;

public class Barbarian extends CharacterClass {

    public Barbarian() {
        name = "Barbarian";
        hp = 12;
        magika = "«Battle Rage»";
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
        return "Barbarian{" +
                "name='" + name + '\'' +
                ", magika='" + magika + '\'' +
                ", hp=" + hp +
                '}';
    }

    @Override
    public void acceptOperation(DataElementVisitor visitor) {
        visitor.visit(this);
    }
}
