package Lesson_1;

import java.util.Arrays;

public class SwapElements {

    public static void main(String[] args) {
        Double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        SwapElements sw = new SwapElements();

        sw.swapElement(arr, 1,2);

        System.out.println(Arrays.toString(arr));
    }

    void swapElement(Object[] mass, int src, int dsc){
        Object tmp = mass[dsc];
        mass[dsc] = mass[src];
        mass[src] = tmp;
    }
}
