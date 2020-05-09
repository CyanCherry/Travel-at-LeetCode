package A_Array;

import java.util.Arrays;

public class C_RotateArray {
    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = new int[k];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        if (nums.length - k >= 0)
            System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] array0 = {1, 2, 3, 4, 5, 6, 7};
        rotate(array0, 3);
        System.out.println(Arrays.equals(array0, new int[]{5, 6, 7, 1, 2, 3, 4}));
        int[] array1 = {-1, -100, 3, 99};
        rotate(array1, 2);
        System.out.println(Arrays.equals(array1, new int[]{3, 99, -1, -100}));
    }
}
