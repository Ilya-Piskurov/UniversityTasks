package com.sumdu;

import com.sumdu.meal.MealBuilder;

public class BuilderPatternDemo {

    public static void main(String[] args) {
	    var mealBuilder = new MealBuilder();
        var vegMeal = mealBuilder.prepareVegMeal();
        var nonVegMeal = mealBuilder.prepareNonVegMeal();

        System.out.println("Вивожу веганське замовлення:");
        vegMeal.showItems();
        System.out.println("Загальна ціна: " + vegMeal.getCost());

        System.out.println("\n\nВивожу не веганське замовлення");
        nonVegMeal.showItems();
        System.out.println("Загальна ціна: " + nonVegMeal.getCost());
    }
}
