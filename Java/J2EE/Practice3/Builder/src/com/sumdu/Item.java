package com.sumdu;

import com.sumdu.packages.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
