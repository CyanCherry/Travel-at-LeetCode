package I_Others;

public class C_ReverseBits {
    static class Solution {
        // treat n as an unsigned value
        static int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result = result << 1;
                if ((n & 1) != 0)
                    result = result ^ 1;
                n = n >>> 1;
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
