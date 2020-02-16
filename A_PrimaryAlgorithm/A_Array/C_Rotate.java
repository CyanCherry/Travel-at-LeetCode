package A_Array;

import java.util.Arrays;

public class C_Rotate {
    static class Solution {
        void rotate(int[] nums, int k) {
            k = k % nums.length;
            int[] tmp = new int[k];
            System.arraycopy(nums, nums.length - k, tmp, 0, k);
            if (nums.length - k >= 0)
                System.arraycopy(nums, 0, nums, k, nums.length - k);
            System.arraycopy(tmp, 0, nums, 0, k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(array, k);
        System.out.println(Arrays.toString(array));
        int[] array1 = {-1, -100, 3, 99};
        k = 2;
        solution.rotate(array1, k);
        System.out.println(Arrays.toString(array1));
    }
}
