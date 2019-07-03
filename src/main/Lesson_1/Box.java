package Lesson_1;

import Lesson_1.Fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitBox = new ArrayList<T>();

    public Box() {
    }

    public Box(T[] fruits){
        fruitBox.addAll(Arrays.asList(fruits));
    }

    public void add(T fruit){
        fruitBox.add(fruit);
    }

    public float getWeight(){
        if (fruitBox.size() == 0){
            return 0;
        }else {
            float singleWeight = fruitBox.get(0).getSingleWeight();
            return fruitBox.size() * singleWeight;
        }

    }

    public boolean compare(Box b){
        if (this.getWeight() == b.getWeight()) return true;
        else return false;
    }

    public void pour(Box<T> b){
        for (T fruit: fruitBox) {
            b.add(fruit);
        }

        fruitBox.clear();
    }
}
