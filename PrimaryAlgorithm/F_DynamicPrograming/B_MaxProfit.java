package F_DynamicPrograming;

public class B_MaxProfit {
    static class Solution {
        static int maxProfit(int[] prices) {
            if (prices.length <= 1)
                return 0;
            if (prices.length == 2) {
                int profit = prices[1] - prices[0];
                return Math.max(profit, 0);
            }
            int minIn = prices[0];
            int profit = prices[1] - prices[0];
            for (int price : prices) {
                if (price < minIn)
                    minIn = price;
                else if (price - minIn > profit)
                    profit = price - minIn;
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        assert Solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5;
        assert Solution.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0;
    }
}
