package ru.elonmusk.simulator.flight;

import java.util.ArrayList;

public class Space {
    ArrayList<Body> bodies;

    public Space() {
        Planet sun = new Planet(1989000e24, null);
        Planet[] planets = {
             new Planet(5.976e24, sun)
        };
        for (Planet planet : planets)
            bodies.add(planet);
    }
}
