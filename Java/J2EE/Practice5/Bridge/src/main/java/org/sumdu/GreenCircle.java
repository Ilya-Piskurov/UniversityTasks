package org.sumdu;

public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.printf("\nGreenCircle [x: %d, y: %d, radius: %d]\n", x, y, radius);
    }
}
