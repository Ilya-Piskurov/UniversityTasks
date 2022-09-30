package com.sumdu.drinks;

import com.sumdu.packages.Bottle;
import com.sumdu.packages.Packing;

public class Cola extends ColdDrink {
    @Override
    public String name() {
        return "Кока-кола";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 20.00f;
    }
}
