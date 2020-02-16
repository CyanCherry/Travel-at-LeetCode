package A_Array;

public class B_MaxProfit {
    static class Solution {
        int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 0; i + 1 < prices.length; i++) {
                if (prices[i] < prices[i + 1])
                    maxProfit += prices[i + 1] - prices[i];
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(array) == 7);
        int[] array1 = {1, 2, 3, 4, 5};
        System.out.println(new Solution().maxProfit(array1) == 4);
        int[] array2 = {7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(array2) == 0);
    }
}
