/**
 * @author CD
 * @date 10/29/2024
 * @description
 */
public class Code312_BurstBalloons {

    public int maxCoins(int[] nums) {
        // 边界处理：如果数组为空，直接返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 创建新数组，在首尾添加1，方便处理边界情况
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        //for (int i = 0; i < n; i++) {
        //    newNums[i + 1] = nums[i];
        //}

        System.arraycopy(nums, 0, newNums, 1, n);

        // dp[i][j]表示戳破(i,j)开区间内的所有气球能得到的最大硬币数
        int[][] dp = new int[n + 2][n + 2];

        // len表示开区间长度
        for (int len = 1; len <= n; len++) {
            // i表示开区间左端点
            for (int i = 1; i <= n - len + 1; i++) {
                // j表示开区间右端点
                int j = i + len - 1;
                // k表示最后戳破的气球
                for (int k = i; k <= j; k++) {
                    // 当前戳破的气球获得的硬币数：左边界 * 当前气球 * 右边界
                    int coins = newNums[i - 1] * newNums[k] * newNums[j + 1];
                    // 加上戳破左半部分和右半部分获得的硬币数
                    coins += dp[i][k - 1] + dp[k + 1][j];
                    // 更新最大值
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }

        // 返回戳破整个区间(1,n)的最大硬币数
        return dp[1][n];
    }
}
