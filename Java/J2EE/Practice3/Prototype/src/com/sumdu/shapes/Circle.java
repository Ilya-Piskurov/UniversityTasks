package com.sumdu.shapes;

public class Circle extends Shape {

    public Circle(String id) {
        super.setId(id);
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Типу малюю круг.");
    }
}
