package Lesson_5.Dop;

import java.util.concurrent.Semaphore;

public class Shipping {

    private int clothes = 0;
    private int food = 0;
    private int fuel = 0;

    private int targetClothes;
    private int targetFood;
    private int targetFuel;
    private Semaphore semaphore = new Semaphore(2, true);


    public Shipping(int targetClothes, int targetFood, int targetFuel) {
        this.targetClothes = targetClothes;
        this.targetFood = targetFood;
        this.targetFuel = targetFuel;
    }

    public void strait(String name){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " проходит по проливу");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " прошел пролив");

        semaphore.release();
    }

    public synchronized boolean isEnoughClothes(){
        return clothes >= targetClothes;
    }

    public synchronized boolean isEnoughFood(){
        return food >= targetFood;
    }

    public synchronized boolean isEnoughFuel(){
        return fuel >= targetFuel;
    }

    public synchronized void addClothes(int clothes){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clothes += clothes;
    }

    public synchronized void addFood(int food){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.food += food;
    }

    public synchronized void addFuel(int fuel){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.fuel += fuel;
    }

    public synchronized int getItems(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 500;
    }
}
