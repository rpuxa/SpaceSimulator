package ru.elonmusk.simulator.flight;

import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.elonmusk.simulator.utils.Constants;
import ru.elonmusk.simulator.utils.MathUtils;

public class Body extends Actor implements Constants {

    Trajectory trajectory;
    public double x, y;
    public Body centralBody;
    public double mass;
    public double[] velocity;
    public double radiusVector, angle;

    public Body(double mass, Body centralBody) {
        this.mass = mass;
        velocity = new double[2];
        this.centralBody = centralBody;
    }

    public Body(Body body) {
        mass = body.mass;
        trajectory = body.trajectory;
        velocity = body.velocity.clone();
        radiusVector = body.radiusVector;
        angle = body.angle;
        centralBody = body.centralBody;
        setX(body.getX());
        setY(body.getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    public double getGravityParameter() {
        return GRAVITATIONAL_CONSTANT * (mass + centralBody.mass);
    }

    public double getVelocityModule() {
        return MathUtils.moduleOfVector(velocity);
    }
}