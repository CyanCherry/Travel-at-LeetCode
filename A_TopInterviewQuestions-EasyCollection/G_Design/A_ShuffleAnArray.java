package G_Design;

import java.util.Arrays;
import java.util.Random;

public class A_ShuffleAnArray {
    private final int[] nums;
    private final int[] shuffleNums;
    private final Random random = new Random();

    public A_ShuffleAnArray(int[] nums) {
        this.nums = nums.clone();
        this.shuffleNums = new int[nums.length];
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        for (int index = 0; index < nums.length; index++) {
            int anotherIndex = random.nextInt(index + 1);
            shuffleNums[index] = shuffleNums[anotherIndex];
            shuffleNums[anotherIndex] = nums[index];
        }
        return shuffleNums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        A_ShuffleAnArray solution = new A_ShuffleAnArray(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.equals(solution.reset(), new int[]{1, 2, 3}));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
