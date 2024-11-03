/**
 * @author CD
 * @date 10/28/2024
 * @description
 */
public class Code309_BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        // 初始化
        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            // 状态转移方程
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        // 最后的最大利润应当是不持有股票状态中的最大值
        return Math.max(sold[n - 1], rest[n - 1]);
    }
    
}
