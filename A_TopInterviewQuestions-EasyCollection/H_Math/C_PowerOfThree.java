package H_Math;

public class C_PowerOfThree {
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

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(1));
        System.out.println(!isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(!isPowerOfThree(45));
        System.out.println(isPowerOfThree(243));
    }
}
