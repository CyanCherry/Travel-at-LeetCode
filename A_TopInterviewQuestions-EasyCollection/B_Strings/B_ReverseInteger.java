package B_Strings;

public class B_ReverseInteger {
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

    public static void main(String[] args) {
        System.out.println(321 == reverse(123));
        System.out.println(-321 == reverse(-123));
        System.out.println(21 == reverse(120));
    }
}
