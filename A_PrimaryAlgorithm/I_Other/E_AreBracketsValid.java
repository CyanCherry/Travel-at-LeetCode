package I_Other;

public class E_AreBracketsValid {
    static class Solution {
        static boolean isValid(String s) {
            if (s.length() % 2 != 0)
                return false;
            char[] stack = new char[s.length()];
            int position = -1;
            for (Character character : s.toCharArray()) {
                if (character == '{' || character == '[' || character == '(') {
                    stack[++position] = character;
                } else if (character == '}') {
                    if (position == -1 || stack[position--] != '{')
                        return false;
                } else if (character == ']') {
                    if (position == -1 || stack[position--] != '[')
                        return false;
                } else if (character == ')') {
                    if (position == -1 || stack[position--] != '(')
                        return false;
                }
            }
            return position == -1;
        }
    }

    public static void main(String[] args) {
        assert Solution.isValid("()");
        assert Solution.isValid("()[]{}");
        assert !Solution.isValid("(]");
        assert !Solution.isValid("([)]");
        assert Solution.isValid("{[]}");
        assert !Solution.isValid("}[]}");
    }
}
