package H_Math;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_FizzBuzz {
    static List<String> fizzBuzz(int n) {
        List<String> result = Arrays.asList(new String[n]);
        for (int index = 0; index < n; ) {
            result.set(index, String.valueOf(++index));
        }
        for (int index = 2; index < n; index += 3) {
            result.set(index, "Fizz");
        }
        for (int index = 4; index < n; index += 5) {
            result.set(index, "Buzz");
        }
        for (int index = 14; index < n; index += 15) {
            result.set(index, "FizzBuzz");
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        System.out.println(test1.equals(fizzBuzz(15)));
        List<String> test2 = Collections.emptyList();
        System.out.println(test2.equals(fizzBuzz(0)));
    }
}
