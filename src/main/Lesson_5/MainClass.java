package Lesson_5;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch prepare = new CountDownLatch(CARS_COUNT);
        CountDownLatch finish = new CountDownLatch(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), prepare, finish);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        while (true){
            if (prepare.getCount() == 0){
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                break;
            }
        }

        while (true){
            if (finish.getCount() == 0){
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                break;
            }
        }

    }
}
