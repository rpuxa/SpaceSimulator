package ru.elonmusk.simulator.flight;


public class Planet extends Body {

    double radius;

    public Planet(double mass, Body centralBody) {
        super(mass, centralBody);
    }
}
