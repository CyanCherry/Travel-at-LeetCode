package A_Array;

import java.util.Arrays;

public class D_ContainsDuplicate {
    static class Solution {
        boolean containsDuplicate(int[] nums) {
            if (nums.length < 2)
                return false;
            Arrays.sort(nums);
            for (int i = 0; i + 1 < nums.length; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(array1));
        int[] array2 = {1, 2, 3, 4};
        System.out.println(new Solution().containsDuplicate(array2));
        int[] array3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(new Solution().containsDuplicate(array3));
    }
}
