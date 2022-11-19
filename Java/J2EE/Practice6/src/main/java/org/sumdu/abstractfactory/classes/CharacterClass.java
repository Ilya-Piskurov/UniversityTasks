package org.sumdu.abstractfactory.classes;

public abstract class CharacterClass {
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
