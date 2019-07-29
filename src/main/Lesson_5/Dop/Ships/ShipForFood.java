package Lesson_5.Dop.Ships;

import Lesson_5.Dop.Shipping;

public class ShipForFood extends Ship {
    public ShipForFood(Shipping shipping) {
        super(shipping, "еда");
    }

    @Override
    public boolean isEnough() {
        return shipping.isEnoughFood();
    }

    @Override
    public void unload() {
        shipping.addFood(items);
    }
}
