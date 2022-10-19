package org.sumdu;

public class MementoPatternDemo {

    public static void main(String[] args) {

        Character character = new Character("Клінт Іствуд", "Ковбой");
        Repo repo = new Repo();

        character.writeInfo();
        Memento save = character.getAttributes().save();
        repo.addSave(save);

        character.regenAttributes();
        character.writeInfo();

        save = character.getAttributes().save();
        repo.addSave(save);

        System.out.println("\nЗавантажую перше збереження...");
        character.loadAttributes(repo.getSave(0));
        character.writeInfo();
    }
}