import java.util.Arrays;

/**
 * @author CD
 * @date 10/30/2024
 * @description
 */
public class Code322_CoinChange {

    public static int coinChange(int[] coins, int amount) {
        // 定义 dp 数组，dp[i] 表示凑成金额 i 的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // 初始化为 amount + 1，表示无穷大
        dp[0] = 0;  // 凑成金额 0 所需硬币数为 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  // 更新 dp[i]
                }
            }
        }

        // 如果 dp[amount] 没有更新，返回 -1，否则返回 dp[amount]
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
