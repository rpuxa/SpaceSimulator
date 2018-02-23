package ru.elonmusk.simulator.flight;

public class Spacecraft extends Body {

    double fuelMass;

    public Spacecraft(double mass,
                      double fuelMass) {
        super(mass);
        this.fuelMass = fuelMass;
    }

    double getFullMass() {
        return fuelMass + mass;
    }
}
