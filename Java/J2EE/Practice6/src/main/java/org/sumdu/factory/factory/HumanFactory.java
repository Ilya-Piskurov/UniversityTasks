package org.sumdu.factory.factory;

import org.sumdu.factory.race.CharacterRace;
import org.sumdu.factory.race.Human;

public class HumanFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Human();
    }
}
