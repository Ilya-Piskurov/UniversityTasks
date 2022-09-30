package com.sumdu.shapes;

public class Rectangle extends Shape {

    public Rectangle(String id) {
        super.setId(id);
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Типу малюю прямокутник.");
    }
}
