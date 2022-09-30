package com.sumdu.burgers;

import com.sumdu.Item;
import com.sumdu.packages.Packing;

public abstract class Burger implements Item {
    @Override
    public abstract String name();

    @Override
    public abstract Packing packing();

    @Override
    public abstract float price();
}
