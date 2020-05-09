package A_Array;

public class B_BestTimeToBuyAndSellStockII {
    static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i + 1 < prices.length; i++) {
            if (prices[i] < prices[i + 1])
                maxProfit += prices[i + 1] - prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(7 == maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(4 == maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(0 == maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
