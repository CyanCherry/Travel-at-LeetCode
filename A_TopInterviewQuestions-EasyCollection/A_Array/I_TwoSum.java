package A_Array;

import java.util.Arrays;
import java.util.HashMap;

public class I_TwoSum {
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int currentTarget = target - nums[index];
            if (hashMap.containsKey(currentTarget))
                return new int[]{hashMap.get(currentTarget), index};
            hashMap.put(nums[index], index);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.equals(new int[]{1, 2}, twoSum(new int[]{2, 7, 12, 15}, 19)));
    }
}
