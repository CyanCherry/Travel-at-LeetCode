package H_Math;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_FizzBuzz {
    static class Solution {
        static List<String> fizzBuzz(int n) {
            String[] result = new String[n];
            for (int index = 0; index < n; )
                result[index] = String.valueOf(++index);
            for (int index = 2; index < n; index += 3)
                result[index] = "Fizz";
            for (int index = 4; index < n; index += 5)
                result[index] = "Buzz";
            for (int index = 14; index < n; index += 15)
                result[index] = "FizzBuzz";
            return Arrays.asList(result);
        }
    }

    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        assert test1.equals(Solution.fizzBuzz(15));
        List<String> test2 = Collections.emptyList();
        assert test2.equals(Solution.fizzBuzz(0));
    }
}
