package org.sumdu;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    private List<Memento> saves;

    public Repo() {
        saves = new ArrayList<>();
    }

    public void addSave(Memento memento) {
        saves.add(memento);
    }

    public Memento getSave(int index) {
        return saves.get(index);
    }

    public Memento getLastSave() {
        if (saves.size() == 0) {
            return null;
        }
        return saves.get(saves.size() - 1);
    }
}
