package Lesson_5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable{
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private CountDownLatch cdl;
    private CountDownLatch cd2;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdl, CountDownLatch cd2) {
        this.race = race;
        this.speed = speed;
        this.cdl = cdl;
        this.cd2 = cd2;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (cd2.getCount() == CARS_COUNT){
            System.out.println(this.name + " WIN!");
        }
        cd2.countDown();
        try {
            cd2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
