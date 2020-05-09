package B_Strings;

import java.util.Arrays;

public class A_ReverseString {
    static void reverseString(char[] s) {
        int maxIndex = s.length - 1;
        int endIndex = s.length / 2;
        char tmp;
        int anotherIndex;
        for (int index = 0; index < endIndex; index++) {
            tmp = s[index];
            anotherIndex = maxIndex - index;
            s[index] = s[anotherIndex];
            s[anotherIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] test0 = "hello".toCharArray();
        reverseString(test0);
        System.out.println(Arrays.equals(
            test0,
            "olleh".toCharArray()
        ));
        char[] test1 = "Hannah".toCharArray();
        reverseString(test1);
        System.out.println(Arrays.equals(
            test1,
            "hannaH".toCharArray()
        ));
    }
}
