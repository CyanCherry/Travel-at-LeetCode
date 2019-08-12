package B_String;

public class B_IntReverse {
    static class Solution {
        static int reverse(int x) {
            try {
                return x < 0 ?
                        -Integer.parseInt(new StringBuilder(String.valueOf(-x)).reverse().toString()) :
                        Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
            } catch (NumberFormatException err) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int test1 = 123456489;
        int test2 = 2100009999;
        int test3 = -10086;
        System.out.println(Solution.reverse(test1));
        System.out.println(Solution.reverse(test2));
        System.out.println(Solution.reverse(test3));
    }
}
