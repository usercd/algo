/**
 * @author CD
 * @date 10/7/2024
 * @description
 */
public class Code121_BestTimeToBuyAndSellStock {

    // 函数：计算最大利润
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;  // 如果数组为空，直接返回 0
        }

        int minPrice = Integer.MAX_VALUE;  // 初始化为最大整数，表示买入的最低价格
        int maxProfit = 0;  // 初始化为 0，表示最大利润

        // 遍历价格数组
        for (int price : prices) {
            // 更新最小买入价格
            if (price < minPrice) {
                minPrice = price;
            } else {
                // 更新最大利润
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;  // 返回最终的最大利润
    }

}
