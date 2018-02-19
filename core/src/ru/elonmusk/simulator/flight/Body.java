package ru.elonmusk.simulator.flight;

public class Body {

    Trajectory trajectory;
    double mass;
    double[] velocity;

    public Body(double mass, double[] velocity) {
        this.mass = mass;
        this.velocity = velocity;
    }



}