package org.sumdu;

public class Memento {

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public Memento(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength     = strength;
        this.dexterity    = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom       = wisdom;
        this.charisma     = charisma;
    }

    public Stats getStats() {
        return new Stats(strength,dexterity,constitution,intelligence,wisdom,charisma);
    }
}
