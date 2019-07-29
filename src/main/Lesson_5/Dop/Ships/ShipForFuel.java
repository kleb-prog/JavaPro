package Lesson_5.Dop.Ships;

import Lesson_5.Dop.Shipping;

public class ShipForFuel extends Ship {
    public ShipForFuel(Shipping shipping) {
        super(shipping, "топливо");
    }

    @Override
    public boolean isEnough() {
        return shipping.isEnoughFuel();
    }

    @Override
    public void unload() {
        shipping.addFuel(items);
    }
}
