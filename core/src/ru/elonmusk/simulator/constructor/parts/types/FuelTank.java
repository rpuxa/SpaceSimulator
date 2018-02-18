package ru.elonmusk.simulator.constructor.parts.types;

import ru.elonmusk.simulator.constructor.parts.shape.Bound;
import ru.elonmusk.simulator.constructor.parts.TypePart;
import ru.elonmusk.simulator.constructor.parts.shape.Shape;


public class FuelTank extends TypePart {
    
    int fuelMass;
    
    public FuelTank(String texturePath, Shape shape, int width, int height) {
        super(texturePath, shape, width, height);
        
    }
}
