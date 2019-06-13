package A_Array;

import java.util.Arrays;

public class K_rotate {
    static class Solution {
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
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solution.rotate(test1);
        System.out.println(Arrays.deepToString(test1));
        int[][] test2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        Solution.rotate(test2);
        System.out.println(Arrays.deepToString(test2));
    }
}
