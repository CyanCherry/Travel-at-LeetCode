package B_Strings;

public class F_MyAtoi {
    static class Solution {
        static int myAtoi(String str) {
            char[] strArray = str.toCharArray();
            int index = 0;
            int result;
            boolean isPositive = true;
            boolean isNumber = false;
            while (index < strArray.length && strArray[index] == ' ')
                index++;
            StringBuilder resultBuilder = new StringBuilder();
            if (index < strArray.length && (strArray[index] == '-' || strArray[index] == '+')) {
                isPositive = strArray[index] == '+';
                index++;
            }
            while (index < strArray.length && strArray[index] == '0')
                index++;
            while (index < strArray.length && strArray[index] > '/' && strArray[index] < ':') {
                resultBuilder.append(strArray[index]);
                isNumber = true;
                index++;
                if (resultBuilder.length() > 10)
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            String resultStr = resultBuilder.toString();
            try {
                result = Integer.parseInt((isPositive ? "+" : "-") + resultStr);
            } catch (NumberFormatException exception) {
                return isNumber ? isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE : 0;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.myAtoi("   -555"));
        System.out.println(Solution.myAtoi("    555"));
        System.out.println(Solution.myAtoi("555"));
        System.out.println(Solution.myAtoi("-555"));
        System.out.println(Solution.myAtoi("-555555555555555555555"));
        System.out.println(Solution.myAtoi("5555555555555555555555"));
        System.out.println(Solution.myAtoi("cherry"));
        System.out.println(Solution.myAtoi("     "));
        System.out.println(Solution.myAtoi("  -"));
        System.out.println(Solution.myAtoi("  +1"));
        System.out.println(Solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
        System.out.println(Solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        System.out.println(Solution.myAtoi("2147483648"));
        System.out.println(Solution.myAtoi("-2147483649"));
    }
}
