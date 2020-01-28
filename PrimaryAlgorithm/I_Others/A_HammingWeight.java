package I_Others;

public class A_HammingWeight {
    static class Solution {
        // treat n as an unsigned value
        static int hammingWeight(int n) {
            int count = 0;
            for (char character : Integer.toBinaryString(n).toCharArray())
                count += character == '1' ? 1 : 0;
            return count;
        }
    }

    public static void main(String[] args) {
        assert Solution.hammingWeight(128) == 1;
        assert Solution.hammingWeight(11) == 3;
        assert Solution.hammingWeight(-3) == 31;
    }
}
