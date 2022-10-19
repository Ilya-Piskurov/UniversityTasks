package org.sumdu;

public class BridgePatternDemo {
    public static void main(String[] args) {

        Shape greenCircle = new Circle(new GreenCircle(), 20, 20, 5);
        Shape redCircle   = new Circle(new RedCircle(), 10, 10, 12);

        greenCircle.draw();
        redCircle.draw();
    }
}