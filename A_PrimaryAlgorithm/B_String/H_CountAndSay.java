package B_String;

public class H_CountAndSay {
    static class Solution {
        static String countAndSay(int n) {
            StringBuilder result = new StringBuilder();
            result.append('1');
            for (int index = 1; index < n; index++) {
                StringBuilder newResult = new StringBuilder();
                char[] resultArray = result.toString().toCharArray();
                char currentDigit = resultArray[0];
                int currentCount = 1;
                for (int resultIndex = 1; resultIndex < result.length(); resultIndex++) {
                    char digit = resultArray[resultIndex];
                    if (digit == currentDigit) {
                        currentCount++;
                    } else {
                        newResult.append(currentCount);
                        newResult.append(currentDigit);
                        currentDigit = digit;
                        currentCount = 1;
                    }
                }
                newResult.append(currentCount);
                newResult.append(currentDigit);
                result = newResult;
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        assert Solution.countAndSay(1).equals("1");
        assert Solution.countAndSay(4).equals("1211");
    }
}
