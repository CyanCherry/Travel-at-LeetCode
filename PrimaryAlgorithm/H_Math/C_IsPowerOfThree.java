package H_Math;

public class C_IsPowerOfThree {
    static class Solution {
        static boolean isPowerOfThree(int n) {
            // Math.log() is so slow!!
            // double result = Math.log10(n) / Math.log10(3);
            // return result == (int) result;

            /*
             * 3 is a prime, and 1162261467 is the maximum power of 3
             * which less than INT_MAX,
             * that means each power of 3 must be a factor of 1162261467,
             * and each factor of 1162261467 must be a power of 3.
             */
            return n > 0 && 1162261467 % n == 0;
        }
    }

    public static void main(String[] args) {
        assert Solution.isPowerOfThree(27);
        assert Solution.isPowerOfThree(1);
        assert !Solution.isPowerOfThree(0);
        assert Solution.isPowerOfThree(9);
        assert !Solution.isPowerOfThree(45);
        assert Solution.isPowerOfThree(243);
    }
}
