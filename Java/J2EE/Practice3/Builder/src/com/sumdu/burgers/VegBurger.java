package com.sumdu.burgers;

import com.sumdu.packages.Packing;
import com.sumdu.packages.Wrapper;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Вегетаріанський бургер";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 45.99f;
    }
}
