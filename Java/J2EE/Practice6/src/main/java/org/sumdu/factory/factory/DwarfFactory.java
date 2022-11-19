package org.sumdu.factory.factory;

import org.sumdu.factory.race.CharacterRace;
import org.sumdu.factory.race.Dwarf;

public class DwarfFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Dwarf();
    }
}
