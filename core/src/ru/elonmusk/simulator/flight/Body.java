package ru.elonmusk.simulator.flight;

import ru.elonmusk.simulator.utils.Constants;
import ru.elonmusk.simulator.utils.MathUtils;

public class Body implements Constants {

    Trajectory trajectory;
    public double x, y;
    public Body centralBody;
    public double mass;
    public double[] velocity;
    public double radiusVector, angle;

    public Body(double mass) {
        this.mass = mass;
        velocity = new double[2];
    }

    public Body(Body body) {
        mass = body.mass;
        trajectory = body.trajectory;
        velocity = body.velocity.clone();
        radiusVector = body.radiusVector;
        angle = body.angle;
    }

    public double getGravityParameter() {
        return GRAVITATIONAL_CONSTANT * (mass + centralBody.mass);
    }

    public double getVelocityModule() {
        return MathUtils.moduleOfVector(velocity);
    }
}