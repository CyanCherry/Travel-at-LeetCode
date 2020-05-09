package F_DynamicPrograming;

public class A_ClimbingStairs {
    static int climbStairs(int n) {
        int[] results = new int[]{1, 2, 3};
        for (int index = 3; index < n; index++) {
            results[index % 3] = results[(index - 1) % 3] + results[(index - 2) % 3];
        }
        return results[(n - 1) % 3];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1) == 1);
        System.out.println(climbStairs(2) == 2);
        System.out.println(climbStairs(3) == 3);
    }
}
