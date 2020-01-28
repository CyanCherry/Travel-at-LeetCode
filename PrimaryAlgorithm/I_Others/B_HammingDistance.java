package I_Others;

public class B_HammingDistance {
    static class Solution {
        static int hammingDistance(int x, int y) {
            int xor = x ^ y, count = 0;
            while (xor != 0) {
                count += xor % 2 == 1 ? 1 : 0;
                xor >>>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        assert Solution.hammingDistance(1, 4) == 2;
        assert Solution.hammingDistance(3, 1) == 1;
        assert Solution.hammingDistance(0, 0) == 0;
    }
}
