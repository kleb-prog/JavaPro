package Lesson_1;

import java.util.ArrayList;

public class ConvertToList<T> {

    public static void main(String[] args) {
        ConvertToList<Integer> list = new ConvertToList<Integer>(new Integer[]{1, 2, 3, 4 ,5});
        System.out.println(list.toArrayList());
        ArrayList<Double> doubleList = new ConvertToList<Double>(new Double[]{1.2, 2.0, 3.0, 4.0, 5.0}).toArrayList();
        System.out.println(doubleList);
    }

    private T[] arr;

    public ConvertToList(T[] arr) {
        this.arr = arr;
    }

    ArrayList<T> toArrayList(){
        ArrayList<T> arrlist = new ArrayList<T>();

        for (T unit:arr) {
            arrlist.add(unit);
        }
        return arrlist;
    }
}
