package A_Array;

import java.util.Arrays;

public class A_RemoveDuplicates {
    static class Solution {
        int removeDuplicates(int[] nums) {
            if (nums.length == 0)
                return 0;
            int length = 1;
            int currentNumber = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != currentNumber) {
                    currentNumber = nums[i];
                    length++;
                    nums[length - 1] = currentNumber;
                }
            }
            return length;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2};
        System.out.println(new Solution().removeDuplicates(array));
        System.out.println(Arrays.toString(array));
        int[] array2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(array2));
        System.out.println(Arrays.toString(array2));
    }
}
