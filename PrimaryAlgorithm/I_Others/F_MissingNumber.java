package I_Others;

public class F_MissingNumber {
    static class Solution {
        static int missingNumber(int[] nums) {
            /*
             * The result of A number xor itself is zero.
             *
             * Nums contains each number from 0 to nums.length + 1,
             * except the missing one,
             * variable result xor each element of the nums,
             * then, xor each number from 0 to nums.length + 1,
             * the result must be the missing number.
             */
            int result = 0;
            for (int integer : nums)
                result ^= integer;
            for (int index = 0; index < nums.length + 1; index++)
                result ^= index;
            return result;
        }
    }

    public static void main(String[] args) {
        assert Solution.missingNumber(new int[]{3, 0, 1}) == 2;
        assert Solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) == 8;
    }
}
