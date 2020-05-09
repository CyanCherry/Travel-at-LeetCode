package B_Strings;

public class I_LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int minStringLength = strs[0].length();
        for (int stringsIndex = 1; stringsIndex < strs.length; stringsIndex++) {
            if (strs[stringsIndex].length() < minStringLength)
                minStringLength = strs[stringsIndex].length();
        }
        if (minStringLength == 0)
            return "";
        StringBuilder result = new StringBuilder();
        char[][] stringArrays = new char[strs.length][];
        for (int stringsIndex = 0; stringsIndex < strs.length; stringsIndex++)
            stringArrays[stringsIndex] = strs[stringsIndex].toCharArray();

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

    public static void main(String[] args) {
        System.out.println("fl".equals(longestCommonPrefix(new String[]{"flower", "flow", "flight"})));
        System.out.println("".equals(longestCommonPrefix(new String[]{"dog", "race car", "car"})));
        System.out.println("".equals(longestCommonPrefix(new String[]{})));
    }
}
