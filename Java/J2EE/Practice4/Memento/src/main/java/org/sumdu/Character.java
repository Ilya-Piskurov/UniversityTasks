package org.sumdu;

public class Character {

    private final String name;
    private final String heroClass;
    private Stats attributes;

    public Character(String name, String heroClass) {

        this.name = name;
        this.heroClass = heroClass;

        attributes = Stats.generate();
    }

    public void writeInfo() {
        System.out.printf("Name: %s\nClass: %s\n\n", name, heroClass);
        attributes.writeStats();
    }

    public void regenAttributes(){
        attributes = Stats.generate();
    }

    public Stats getAttributes() {
        return attributes;
    }

    public void loadAttributes(Memento memento) {
        this.attributes.loadState(memento);
    }
}
