package B_Strings;

public class C_FirstUniqueCharacterInAString {
    static int firstUniqChar(String string) {
        // The string may be really long,
        // so it will take a lot of time to traverse it.
        //
        // HashSet<Character> characterHashSet = new HashSet<>();
        // for (int index = 0; index < string.length(); index++) {
        //     char character = string.charAt(index);
        //     if(characterHashSet.contains(character))
        //         continue;
        //     characterHashSet.add(character);
        //     if (string.lastIndexOf(character) == index) {
        //         return index;
        //     }
        // }

        int result = -1;
        for (char character = 'a'; character < '{'; character++) {
            int index = string.indexOf(character);
            if (index != -1 && index == string.lastIndexOf(character) && (index < result || result == -1))
                result = index;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(0 == firstUniqChar("leetcode"));
        System.out.println(2 == firstUniqChar("loveleetcode"));
    }
}
