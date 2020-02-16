package H_Math;

import java.util.Arrays;

public class B_CountPrimes {
    static class Solution {
        static int countPrimes(int n) {
            boolean[] primes = new boolean[n];
            Arrays.fill(primes, true);
            int count = 0;
            for (int checker = 2; checker < n; checker++) {
                if (primes[checker]) {
                    count++;
                    for (int index = checker + checker; index < n; index += checker)
                        primes[index] = false;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        assert Solution.countPrimes(10) == 4;
        assert Solution.countPrimes(1) == 0;
        assert Solution.countPrimes(2) == 0;
        assert Solution.countPrimes(3) == 1;
        assert Solution.countPrimes(4) == 2;
        assert Solution.countPrimes(0) == 0;
        assert Solution.countPrimes(1500000) == 114155;
    }
}
