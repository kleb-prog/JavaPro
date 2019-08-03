package Lesson_8;

public class Snake {

    static final int SIZE = 7;
    static int[][] matrix = new int[SIZE][SIZE];

    public static void main(String[] args) {
        int counter = 1;
        int j, k, p = SIZE/2;

        for (k = 1; k <= p; k++) {
            for (j = k - 1; j < SIZE - k + 1; j++) {
                matrix[k - 1][j] = counter++;
            }
            for (j = k; j < SIZE - k + 1; j++) {
                matrix[j][SIZE - k] = counter++;
            }
            for (j = SIZE - k - 1;j >= k - 1; --j) {
                matrix[SIZE - k][j] = counter++;
            }
            for (j = SIZE - k - 1;j >= k; j--){
                matrix[j][k - 1] = counter++;
            }
        }
        if (SIZE % 2 != 0){
            matrix[p][p] = SIZE * SIZE;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int l = 0; l < SIZE; l++) {
                int tmp = matrix[i][l];
                if (tmp < 10){
                    System.out.print(" " + tmp + " ");
                }else System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }
}
