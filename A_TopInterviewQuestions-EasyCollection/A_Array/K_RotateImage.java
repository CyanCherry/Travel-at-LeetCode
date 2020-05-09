package A_Array;

import java.util.Arrays;

public class K_RotateImage {
    static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int[] array : matrix) {
            if (array.length != length)
                throw new IllegalArgumentException("Not a matrix.");
        }
        int maxIndex = length - 1;
        int tmp;
        for (int index = 0; index < length / 2; index++) {
            for (int innerIndex = index; innerIndex < maxIndex - index; innerIndex++) {
                tmp = matrix[index][innerIndex];
                matrix[index][innerIndex] = matrix[maxIndex - innerIndex][index];
                matrix[maxIndex - innerIndex][index] = matrix[maxIndex - index][maxIndex - innerIndex];
                matrix[maxIndex - index][maxIndex - innerIndex] = matrix[innerIndex][maxIndex - index];
                matrix[innerIndex][maxIndex - index] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test0 = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(test0);
        System.out.println(Arrays.deepEquals(
            test0,
            new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
            }
        ));
        int[][] test1 = new int[][]{
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        rotate(test1);
        System.out.println(Arrays.deepEquals(
            test1,
            new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
            }
        ));
    }
}
