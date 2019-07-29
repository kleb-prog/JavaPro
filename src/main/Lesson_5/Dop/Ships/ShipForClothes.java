package Lesson_5.Dop.Ships;

import Lesson_5.Dop.Shipping;

public class ShipForClothes extends Ship {

    public ShipForClothes(Shipping shipping) {
        super(shipping, "одежда");
    }

    @Override
    public boolean isEnough() {
        return shipping.isEnoughClothes();
    }

    @Override
    public void unload() {
        shipping.addClothes(items);
    }
}
