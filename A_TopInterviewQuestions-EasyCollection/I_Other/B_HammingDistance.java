package I_Other;

public class B_HammingDistance {
    static int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4) == 2);
        System.out.println(hammingDistance(3, 1) == 1);
        System.out.println(hammingDistance(0, 0) == 0);
    }
}
