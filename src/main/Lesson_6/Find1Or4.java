package Lesson_6;

public class Find1Or4 {

    public boolean isContained1Or4(int[] arr){
        int one = 0;
        int four = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) one++;
            if (arr[i] == 4) four++;
        }

        return (one > 0 && four > 0);
    }
}
