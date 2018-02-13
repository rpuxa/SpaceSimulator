package ru.elonmusk.simulator.flight;

public class Spacecraft extends Body {

    double fuelMass;

    public Spacecraft(double mass, double[] velocity, double fuelMass) {
        super(mass, velocity);
        this.fuelMass = fuelMass;
    }

    double getFullMass() {
        return fuelMass + mass;
    }
}
