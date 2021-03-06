package I_Other;

public class E_ValidParentheses {
    static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] stack = new char[s.length()];
        int position = -1;
        for (Character character : s.toCharArray()) {
            switch (character) {
                case '{':
                case '[':
                case '(':
                    stack[++position] = character;
                    break;
                case '}':
                    if (position == -1 || stack[position--] != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (position == -1 || stack[position--] != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (position == -1 || stack[position--] != '(') {
                        return false;
                    }
                    break;
            }
        }
        return position == -1;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(isValid("()")));
        System.out.println(isValid("()[]{}"));
        System.out.println(Boolean.FALSE.equals(isValid("(]")));
        System.out.println(Boolean.FALSE.equals(isValid("([)]")));
        System.out.println(Boolean.TRUE.equals(isValid("{[]}")));
        System.out.println(Boolean.FALSE.equals(isValid("}[]}")));
    }
}
