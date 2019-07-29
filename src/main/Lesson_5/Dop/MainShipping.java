package Lesson_5.Dop;

import Lesson_5.Dop.Ships.ShipForClothes;
import Lesson_5.Dop.Ships.ShipForFood;
import Lesson_5.Dop.Ships.ShipForFuel;

import java.util.ArrayList;

public class MainShipping {
    public static void main(String[] args) {
        Shipping shipping = new Shipping(2700, 5900, 8500);

        ShipForClothes shipForClothes = new ShipForClothes(shipping);
        ShipForFood shipForFood = new ShipForFood(shipping);
        ShipForFuel shipForFuel = new ShipForFuel(shipping);

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new Thread(shipForClothes));
        threads.add(new Thread(shipForFood));
        threads.add(new Thread(shipForFuel));

        for (Thread th:threads) {
            th.start();
        }

        for (Thread th:threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Заказ выполнен");
    }

}
