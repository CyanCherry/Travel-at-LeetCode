package H_Math;

public class D_RomanToInteger {
    static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        boolean I = false;
        boolean X = false;
        boolean C = false;
        int result = 0;
        for (char character : chars) {
            switch (character) {
                case 'I':
                    I = true;
                    X = false;
                    C = false;
                    result += 1;
                    break;
                case 'V':
                    if (I) {
                        result -= 2;
                    }
                    I = false;
                    X = false;
                    C = false;
                    result += 5;
                    break;
                case 'X':
                    if (I) {
                        result -= 2;
                        X = false;
                    } else {
                        X = true;
                    }
                    I = false;
                    C = false;
                    result += 10;
                    break;
                case 'L':
                    if (X) {
                        result -= 20;
                    }
                    I = false;
                    X = false;
                    C = false;
                    result += 50;
                    break;
                case 'C':
                    if (X) {
                        result -= 20;
                        C = false;
                    } else {
                        C = true;
                    }
                    I = false;
                    X = false;
                    result += 100;
                    break;
                case 'D':
                    if (C) {
                        result -= 200;
                    }
                    I = false;
                    X = false;
                    C = false;
                    result += 500;
                    break;
                case 'M':
                    if (C) {
                        result -= 200;
                    }
                    I = false;
                    X = false;
                    C = false;
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III") == 3);
        System.out.println(romanToInt("IV") == 4);
        System.out.println(romanToInt("IX") == 9);
        System.out.println(romanToInt("LVIII") == 58);
        System.out.println(romanToInt("DCXXI") == 621);
        System.out.println(romanToInt("MCMXCIV") == 1994);
    }
}
