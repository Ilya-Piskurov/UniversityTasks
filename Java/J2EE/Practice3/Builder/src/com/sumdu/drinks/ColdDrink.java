package com.sumdu.drinks;

import com.sumdu.Item;
import com.sumdu.packages.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public abstract String name();

    @Override
    public abstract Packing packing();

    @Override
    public abstract float price();
}
