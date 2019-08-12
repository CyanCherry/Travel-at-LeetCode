package A_Array;

public class E_SingleNumber {
    static class Solution {
        int singleNumber(int[] nums) {
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result ^= nums[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {2, 2, 1};
        System.out.println(new Solution().singleNumber(array1));
        int[] array2 = {4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(array2));
    }
}
