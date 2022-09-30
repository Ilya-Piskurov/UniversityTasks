package com.sumdu.meal;

import com.sumdu.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0f;
        for (Item item: items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item: items) {
            System.out.println("------------------------------");
            System.out.printf("Ім'я продукту: %s\nОбгортка: %s\nЦіна: %.2f\n",
                    item.name(), item.packing().packageType(), item.price());
        }
    }
}
