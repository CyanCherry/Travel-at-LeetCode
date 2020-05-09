package I_Other;

public class A_NumberOf1Bits {
    // treat n as an unsigned value
    static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(128) == 1);
        System.out.println(hammingWeight(11) == 3);
        System.out.println(hammingWeight(-3) == 31);
    }
}
