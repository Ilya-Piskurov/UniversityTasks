package org.sumdu;

public class Stats {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public static Stats generate() {
        return new Stats(
                Dice.roll(),
                Dice.roll(),
                Dice.roll(),
                Dice.roll(),
                Dice.roll(),
                Dice.roll()
        );
    }

    public Stats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength     = strength;
        this.dexterity    = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom       = wisdom;
        this.charisma     = charisma;
    }

    public Memento save() {
        return new Memento(
                strength,
                dexterity,
                constitution,
                intelligence,
                wisdom,
                charisma
        );
    }

    public void loadState(Memento memento) {
        Stats savedState = memento.getStats();
        strength = savedState.strength;
        dexterity = savedState.dexterity;
        constitution = savedState.constitution;
        intelligence = savedState.intelligence;
        wisdom = savedState.wisdom;
        charisma = savedState.charisma;
    }

    public void writeStats() {
        System.out.println("================");
        System.out.println("=  Attributes  =");
        System.out.println("================");
        System.out.printf(
                "Strength:  %d\n" +
                "Dexterity: %d\n" + "" +
                "Constitution: %d\n" +
                "Intelligence: %d\n" +
                "Wisdom: %d\n" +
                "Charisma: %d\n",
                strength, dexterity, constitution, intelligence, wisdom, charisma
        );
    }
}
