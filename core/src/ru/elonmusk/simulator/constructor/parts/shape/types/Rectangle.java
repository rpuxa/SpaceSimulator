package ru.elonmusk.simulator.constructor.parts.shape.types;

import ru.elonmusk.simulator.constructor.parts.shape.Bound;
import ru.elonmusk.simulator.constructor.parts.shape.Shape;

public class Rectangle extends Shape {

    public Rectangle() {
        super(null);
        bounds = new Bound[] {
                new Bound(0, 0, 0, 1),
                new Bound(0, 1, 1, 1),
                new Bound(1, 1, 1, 0),
                new Bound(1, 0, 0, 0)
        };
    }
}
