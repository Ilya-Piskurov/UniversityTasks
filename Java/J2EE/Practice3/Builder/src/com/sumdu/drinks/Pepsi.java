package com.sumdu.drinks;

import com.sumdu.packages.Bottle;
import com.sumdu.packages.Packing;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Пепсі";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float price() {
        return 19.50f;
    }
}
