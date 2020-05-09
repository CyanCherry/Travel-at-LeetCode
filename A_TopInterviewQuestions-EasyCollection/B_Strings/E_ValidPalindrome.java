package B_Strings;

public class E_ValidPalindrome {
    static boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int originLength = sArray.length;
        int length = 0;
        for (int index = 0; index < originLength; index++) {
            char character = sArray[index];
            if (character > '/' && character < ':' || character > '`' && character < '{') {
                sArray[length] = character;
                length++;
            } else if (character > '@' && character < '[') {
                sArray[length] = (char) (character + 32);
                length++;
            }
        }
        int lastIndex = length - 1;
        for (int index = 0; index < length / 2; index++)
            if (sArray[index] != sArray[lastIndex - index])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(isPalindrome("A man, a plan, a canal: Panama")));
        System.out.println(Boolean.FALSE.equals(isPalindrome("race a car")));
    }
}
