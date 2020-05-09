package F_DynamicPrograming;

public class C_MaximumSubarray {
    static int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int sum, result = sum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            sum = sum < 0 ? nums[index] : nums[index] + sum;
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        System.out.println(maxSubArray(new int[]{5, -6, 1, 1, 1, 1, 1, 1, 1, -1}) == 7);
        System.out.println(maxSubArray(new int[]{-1}) == -1);
    }
}
