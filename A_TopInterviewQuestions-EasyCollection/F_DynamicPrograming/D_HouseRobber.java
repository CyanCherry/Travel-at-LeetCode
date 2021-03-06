package F_DynamicPrograming;

public class D_HouseRobber {
    static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] results = new int[nums.length];
        boolean robbedLast;
        results[0] = nums[0];
        robbedLast = results[0] <= nums[1];
        results[1] = Math.max(results[0], nums[1]);

        for (int index = 2; index < nums.length; index++) {
            if (robbedLast) {
                int sum = results[index - 2] + nums[index];
                if (sum > results[index - 1]) {
                    results[index] = sum;
                } else {
                    robbedLast = false;
                    results[index] = results[index - 1];
                }
            } else {
                robbedLast = true;
                results[index] = nums[index] + results[index - 2];
            }
        }
        return results[results.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}) == 4);
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}) == 12);
        System.out.println(rob(new int[]{2, 7, 0, 1, 100}) == 107);
        System.out.println(rob(new int[]{1, 2, 1, 0}) == 2);
    }
}
