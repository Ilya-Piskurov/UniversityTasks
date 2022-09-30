package com.sumdu.meal;

import com.sumdu.burgers.ChickenBurger;
import com.sumdu.burgers.VegBurger;
import com.sumdu.drinks.Cola;
import com.sumdu.drinks.Pepsi;

public class MealBuilder {
    public Meal prepareVegMeal() {
        var meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Cola());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        var meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
