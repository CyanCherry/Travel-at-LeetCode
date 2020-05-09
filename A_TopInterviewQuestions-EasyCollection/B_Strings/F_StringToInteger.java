package B_Strings;

public class F_StringToInteger {
    static int myAtoi(String str) {
        if (str.equals("")) {
            return 0;
        }
        long result = 0;
        int weight = 1;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index < str.length()) {
            if (str.charAt(index) == '-') {
                weight = -1;
                index++;
            } else if (str.charAt(index) == '+') {
                index++;
            }
        }
        char character;
        while (index < str.length() && (character = str.charAt(index++)) > '0' - 1 && character < '9' + 1) {
            result = result * 10;
            result += weight * (character - '0');
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(42 == myAtoi("42"));
        System.out.println(-42 == myAtoi("   -42"));
        System.out.println(4193 == myAtoi("4193 with words"));
        System.out.println(0 == myAtoi("words and 987"));
        System.out.println(-2147483648 == myAtoi("-91283472332"));
    }
}
