package Lesson_6;

public class SortArr4 {

    public int[] valuesAfter4(int[] arr){
        int startInd = -1;
        int endInd = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                startInd = i;
            }
        }

        if (startInd == -1){
            throw new RuntimeException("No one 4 find");
        }

        int[] result = new int[endInd - startInd];
        System.arraycopy(arr, startInd + 1, result, 0, result.length);
        return result;
    }
}
