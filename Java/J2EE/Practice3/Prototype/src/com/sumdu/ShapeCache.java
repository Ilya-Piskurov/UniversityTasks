package com.sumdu;

import com.sumdu.shapes.Circle;
import com.sumdu.shapes.Rectangle;
import com.sumdu.shapes.Shape;
import com.sumdu.shapes.Square;

import java.util.HashMap;

public class ShapeCache {
    private final HashMap<String, Shape> shapeMap = new HashMap<>();

    public void loadCache() {
        var circle = new Circle("1");
        shapeMap.put(circle.getId(), circle);

        var rectangle = new Rectangle("2");
        shapeMap.put(rectangle.getId(), rectangle);

        var square = new Square("3");
        shapeMap.put(square.getId(), square);
    }

    public Shape getShape(String id) {
        return (Shape) shapeMap.get(id).clone();
    }
}
