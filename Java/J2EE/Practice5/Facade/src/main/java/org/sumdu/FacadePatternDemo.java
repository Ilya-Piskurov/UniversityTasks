package org.sumdu;

public class FacadePatternDemo {
    public static void main(String[] args) {
        var shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}