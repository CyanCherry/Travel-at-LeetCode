package F_DynamicPrograming;

public class B_BestTimeToBuyAndSellStock {
    static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minIn = prices[0], profit = 0;
        for (int index = 1; index < prices.length; index++) {
            int price = prices[index];
            if (price < minIn) {
                minIn = price;
            }
            if (price - minIn > profit) {
                profit = price - minIn;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);
    }
}
