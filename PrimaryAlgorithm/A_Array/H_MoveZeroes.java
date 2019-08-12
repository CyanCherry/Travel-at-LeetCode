package A_Array;

import java.util.Arrays;

public class H_MoveZeroes {
    static class Solution {
        static void moveZeroes(int[] nums) {
            int notZeroNumber = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i != notZeroNumber) {
                        int tmp = nums[i];
                        nums[i] = nums[notZeroNumber];
                        nums[notZeroNumber] = tmp;
                    }
                    notZeroNumber++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        Solution.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
