package I_Other;

public class C_ReverseBits {
    static class Solution {
        // treat n as an unsigned value
        static int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result |= n & 1;
                n >>>= 1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        assert Solution.reverseBits(0) == 0;
        assert Solution.reverseBits(-3) == -1073741825;
        assert Solution.reverseBits(-1) == -1;
        assert Solution.reverseBits(1) == Integer.MIN_VALUE;
    }
}
