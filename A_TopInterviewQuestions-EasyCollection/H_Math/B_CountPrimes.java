package H_Math;

import java.util.Arrays;

public class B_CountPrimes {
    static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int count = 0;
        for (int checker = 2; checker < n; checker++) {
            if (primes[checker]) {
                count++;
                for (int index = 2 * checker; index < n; index += checker) {
                    primes[index] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10) == 4);
        System.out.println(countPrimes(1) == 0);
        System.out.println(countPrimes(2) == 0);
        System.out.println(countPrimes(3) == 1);
        System.out.println(countPrimes(4) == 2);
        System.out.println(countPrimes(0) == 0);
        System.out.println(countPrimes(1500000) == 114155);
    }
}
