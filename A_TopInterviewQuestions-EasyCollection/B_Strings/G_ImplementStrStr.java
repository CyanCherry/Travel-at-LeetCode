package B_Strings;

public class G_ImplementStrStr {
    static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        if (haystack.length() == needle.length())
            return haystack.equals(needle) ? 0 : -1;
        scanHaystack:
        for (int haystackIndex = 0; haystackIndex + needle.length() <= haystack.length(); haystackIndex++) {
            int needleIndex = 0;
            while (needleIndex < needle.length()) {
                if (needle.charAt(needleIndex) != haystack.charAt(haystackIndex + needleIndex))
                    continue scanHaystack;
                needleIndex++;
            }
            return haystackIndex;
        }
        return -1;
        // can be simplified to only one line of code
        // return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(2 == strStr("hello", "ll"));
        System.out.println(-1 == strStr("aaaaa", "bba"));
        System.out.println(0 == strStr("cherry", ""));
        System.out.println(0 == strStr("", ""));
        System.out.println(-1 == strStr("", "bla"));
        System.out.println(9 == strStr("mississippi", "pi"));
    }
}
