package B_Strings;

public class I_LongestCommonPrefix {
    static class Solution {
        static String longestCommonPrefix(String[] strings) {
            if (strings.length == 0)
                return "";
            int minStringLength = strings[0].length();
            for (int stringsIndex = 1; stringsIndex < strings.length; stringsIndex++) {
                if (strings[stringsIndex].length() < minStringLength)
                    minStringLength = strings[stringsIndex].length();
            }
            if (minStringLength == 0)
                return "";
            StringBuilder result = new StringBuilder();
            char[][] stringArrays = new char[strings.length][];
            for (int stringsIndex = 0; stringsIndex < strings.length; stringsIndex++)
                stringArrays[stringsIndex] = strings[stringsIndex].toCharArray();

            ScanStringArrays:
            for (int stringIndex = 0; stringIndex < minStringLength; stringIndex++) {
                char currentCharacter = stringArrays[0][stringIndex];
                for (int stringArraysIndex = 1; stringArraysIndex < stringArrays.length; stringArraysIndex++) {
                    if (stringArrays[stringArraysIndex][stringIndex] != currentCharacter)
                        break ScanStringArrays;
                }
                result.append(currentCharacter);
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        assert "fl".equals(Solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assert "".equals(Solution.longestCommonPrefix(new String[]{"dog", "race car", "car"}));
        assert "".equals(Solution.longestCommonPrefix(new String[]{}));
    }
}
