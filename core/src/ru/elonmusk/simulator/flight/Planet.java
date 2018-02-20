package ru.elonmusk.simulator.flight;


public class Planet extends Body {

    double radius, eccentricity, focalParameter;

    public Planet(double mass, double radius, double eccentricity) {
        super(mass);
        this.radius = radius;
        this.eccentricity = eccentricity;
    }

}
