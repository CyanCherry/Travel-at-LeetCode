package B_String;

public class B_IntReverse {
    static class Solution {
        static int reverse(int x) {
            long result = 0;
            while (x != 0) {
                result = result * 10 + x % 10;
                x /= 10;
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                    return 0;
            }
            return (int) result;
        }
    }

    public static void main(String[] args) {
        int test1 = 123456789;
        int test2 = 2100009999;
        int test3 = -10086;
        System.out.println(Solution.reverse(test1));
        System.out.println(Solution.reverse(test2));
        System.out.println(Solution.reverse(test3));
        System.out.println(Solution.reverse(Integer.MAX_VALUE));
        System.out.println(Solution.reverse(Integer.MIN_VALUE));
    }
}
