package H_Math;

public class D_RomanToInt {
    static class Solution {
        static int romanToInt(String s) {
            char[] chars = s.toCharArray();
            boolean I = false;
            boolean X = false;
            boolean C = false;
            int result = 0;
            for (char character : chars) {
                if (character == 'I') {
                    I = true;
                    X = false;
                    C = false;
                    result += 1;
                } else if (character == 'V') {
                    if (I)
                        result -= 2;
                    I = false;
                    X = false;
                    C = false;
                    result += 5;
                } else if (character == 'X') {
                    if (I) {
                        result -= 2;
                        X = false;
                    } else
                        X = true;
                    I = false;
                    C = false;
                    result += 10;
                } else if (character == 'L') {
                    if (X)
                        result -= 20;
                    I = false;
                    X = false;
                    C = false;
                    result += 50;
                } else if (character == 'C') {
                    if (X) {
                        result -= 20;
                        C = false;
                    } else
                        C = true;
                    I = false;
                    X = false;
                    result += 100;
                } else if (character == 'D') {
                    if (C)
                        result -= 200;
                    I = false;
                    X = false;
                    C = false;
                    result += 500;
                } else if (character == 'M') {
                    if (C)
                        result -= 200;
                    I = false;
                    X = false;
                    C = false;
                    result += 1000;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        assert Solution.romanToInt("III") == 3;
        assert Solution.romanToInt("IV") == 4;
        assert Solution.romanToInt("IX") == 9;
        assert Solution.romanToInt("LVIII") == 58;
        assert Solution.romanToInt("DCXXI") == 621;
        assert Solution.romanToInt("MCMXCIV") == 1994;
    }
}
