package ru.elonmusk.simulator.constructor.parts.shape;

public class Shape {
    public Bound[] bounds;

    public Shape(Bound[] bounds) {
        //строго по порядку, по часовой стрелке, начиная с точки 0:0
        this.bounds = bounds;
    }
}
