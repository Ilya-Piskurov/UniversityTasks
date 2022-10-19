package org.sumdu;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.printf("\nRedCircle [x: %d, y: %d, radius: %d]\n", x, y, radius);
    }
}
