package ru.elonmusk.simulator.constructor.parts;

import ru.elonmusk.simulator.constructor.parts.shape.types.Rectangle;
import ru.elonmusk.simulator.constructor.parts.types.FuelTank;

public interface Models {
    //Топливные баки
    FuelTank FL100 = new FuelTank("bad", new Rectangle(), 100, 200),
            FL200 = new FuelTank("bad", new Rectangle(), 150, 300);
}
