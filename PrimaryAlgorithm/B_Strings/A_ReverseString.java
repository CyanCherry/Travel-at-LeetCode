package B_Strings;

public class A_ReverseString {
    static class Solution {
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
    }

    public static void main(String[] args) {
        char[] test1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] test2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        Solution.reverseString(test1);
        Solution.reverseString(test2);
        System.out.println(test1);
        System.out.println(test2);
    }
}
