package com.sumdu.burgers;

import com.sumdu.packages.Packing;
import com.sumdu.packages.Wrapper;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Курячий бургер";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 56.50f;
    }
}
