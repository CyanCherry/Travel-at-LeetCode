package F_DynamicPrograming;

public class A_ClimbStairs {
    static class Solution {
        static int climbStairs(int n) {
            n--;
            int[] results = new int[]{1, 2, 3};
            if (n < 3)
                return results[n % 3];
            for (int index = 3; index <= n; index++)
                results[index % 3] = results[(index - 1) % 3] + results[(index - 2) % 3];
            return results[n % 3];
        }
    }

    public static void main(String[] args) {
        assert Solution.climbStairs(1) == 1;
        assert Solution.climbStairs(2) == 2;
        assert Solution.climbStairs(3) == 3;
    }
}
