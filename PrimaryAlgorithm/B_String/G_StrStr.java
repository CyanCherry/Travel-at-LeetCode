package B_String;

public class G_StrStr {
    static class Solution {
        static int strStr(String haystack, String needle) {
            if (haystack.length() < needle.length())
                return -1;
            if (haystack.length() == needle.length())
                return haystack.equals(needle) ? 0 : -1;
            char[] haystackArray = haystack.toCharArray();
            char[] needleArray = needle.toCharArray();
            scanHaystack:
            for (int haystackIndex = 0; haystackIndex + needleArray.length <= haystackArray.length; haystackIndex++) {
                int needleIndex = 0;
                while (needleIndex < needleArray.length) {
                    if (needleArray[needleIndex] != haystackArray[haystackIndex + needleIndex])
                        continue scanHaystack;
                    needleIndex++;
                }
                return haystackIndex;
            }
            return -1;
            // can be simplified to only one line of code
            // return haystack.indexOf(needle);
        }
    }

    public static void main(String[] args) {
        assert 2 == Solution.strStr("hello", "ll");
        assert -1 == Solution.strStr("aaaaa", "bba");
        assert 0 == Solution.strStr("cherry", "");
        assert 0 == Solution.strStr("", "");
        assert -1 == Solution.strStr("", "bla");
        assert 9 == Solution.strStr("mississippi", "pi");
    }
}