package ru.elonmusk.simulator.flight;

import ru.elonmusk.simulator.utils.Constants;

public class Body implements Constants {

    Trajectory trajectory;
    Body parentBody;
    double mass;

    public Body(double mass) {
        this.mass = mass;
    }

    public double[] getVelocity() {
        double module = Math.sqrt(GRAVITATIONAL_CONSTANT * (parentBody.mass + mass) / trajectory.getFocalParameter() *
                (1 + 2 * trajectory.eccentricity * Math.cos(trajectory.anomaly) + trajectory.eccentricity * trajectory.eccentricity));
        return new double[] {
                //TODO Сделать епт
            //module * Math.cos()
        };
    }
}