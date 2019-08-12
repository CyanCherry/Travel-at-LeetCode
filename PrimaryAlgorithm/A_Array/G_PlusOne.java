package A_Array;

import java.util.Arrays;

public class G_PlusOne {
    static class Solution {
        static int[] plusOne(int[] digits) {
            digits[digits.length - 1]++;
            for (int i = digits.length - 1; i > -1; i--) {
                if (digits[i] > 9) {
                    digits[i] = digits[i] % 10;
                    if (i - 1 > -1)
                        digits[i - 1]++;
                    else {
                        int[] tmp = new int[digits.length + 1];
                        tmp[0] = 1;
                        System.arraycopy(digits, 0, tmp, 1, digits.length);
                        digits = tmp;
                    }
                } else {
                    break;
                }
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(Solution.plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(Solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(Solution.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(Solution.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
