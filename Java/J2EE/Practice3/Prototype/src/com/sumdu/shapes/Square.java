package com.sumdu.shapes;

public class Square extends Shape {

    public Square(String id) {
        super.setId(id);
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Типу малюю квадрат.");
    }
}
