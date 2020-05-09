package B_Strings;

public class D_ValidAnagram {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] statistic = new int[26];
        int length = s.length();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int index = 0; index < length; index++) {
            statistic[sArray[index] - 'a']++;
            statistic[tArray[index] - 'a']--;
        }
        for (int element : statistic)
            if (element != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(isAnagram("anagram", "nagaram")));
        System.out.println(Boolean.FALSE.equals(isAnagram("rat", "car")));
    }
}
