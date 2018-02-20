package ru.elonmusk.simulator.constructor.parts;

import ru.elonmusk.simulator.flight.Planet;

public interface Planets {
    Planet[] planets = {
            new Planet(1989000e24, 695.990e6, 0),
            new Planet(5.976e24, 6.378e6, 0.017)
    };
    int SUN = 0;
    int EARTH = 1;
}
