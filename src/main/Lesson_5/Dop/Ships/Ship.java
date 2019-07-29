package Lesson_5.Dop.Ships;

import Lesson_5.Dop.Shipping;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Ship implements Runnable{

    int items = 0;
    private String type;
    Shipping shipping;
    String name;
    private static volatile AtomicInteger COUNTER;
    static {
        COUNTER = new AtomicInteger();
    }

    public Ship(Shipping shipping, String typeItem) {
        COUNTER.incrementAndGet();
        this.shipping = shipping;
        this.type = typeItem;
        this.name = "Корабль " + COUNTER;
    }

    @Override
    public void run() {
        System.out.println(name + " готов");

        while (!isEnough()){

            shipping.strait(name);

            System.out.println(name + " пришел в порт для загрузки груза (" + type + ")");
            load();
            System.out.println(name + " загрузился");

            shipping.strait(name);

            System.out.println(name + " пришел в порт для разгрузки груза (" + type + ")");
            unload();
            System.out.println(name + " разгрузился");
        }

        System.out.println("Заказ по грузу " + type + " выполен");
    }

    public void load(){
        items = shipping.getItems();
    }

    public abstract boolean isEnough();

    public abstract void unload();
}
