package org.sumdu.classes;

import org.sumdu.visitor.DataElement;

public abstract class CharacterClass implements DataElement {
    protected String name;
    protected String magika;
    protected int hp;

    public abstract String getName();
    public abstract int getHp();

    public void printMagika() {
        System.out.println(magika);
    };

    public abstract String toString();
}
