package org.piskurov.model.classes;

public abstract class CharacterClass {
    private String name;
    private String magic;
    private int hp;

    public String getName() {
        return name;
    }

    public String getMagic() {
        return magic;
    }

    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
