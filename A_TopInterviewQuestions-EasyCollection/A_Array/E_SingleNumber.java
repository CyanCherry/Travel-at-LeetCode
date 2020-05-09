package A_Array;

public class E_SingleNumber {
    static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1 == singleNumber(new int[]{2, 2, 1}));
        System.out.println(4 == singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
