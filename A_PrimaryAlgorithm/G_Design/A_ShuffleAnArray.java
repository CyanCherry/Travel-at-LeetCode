package G_Design;

import java.util.Arrays;

public class A_ShuffleAnArray {
    static class Solution {
        private int[] nums;
        private final int[] initNums;

        public Solution(int[] nums) {
            this.nums = Arrays.copyOf(nums, nums.length);
            this.initNums = Arrays.copyOf(nums, nums.length);
        }

        public int[] reset() {
            this.nums = Arrays.copyOf(initNums, initNums.length);
            return nums;
        }

        public int[] shuffle() {
            for (int index = 0; index < nums.length; index++) {
                int anotherIndex = (int) (Math.random() * nums.length);
                int tmp = nums[anotherIndex];
                nums[anotherIndex] = nums[index];
                nums[index] = tmp;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
