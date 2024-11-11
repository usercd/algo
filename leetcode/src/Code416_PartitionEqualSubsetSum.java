/**
 * @author CD
 * @date 11/8/2024
 * @description
 */
public class Code416_PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果总和是奇数，不可能分成两个相等的子集
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 和为 0 的子集总是存在，即空集

        for (int num : nums) {
            // 从后向前更新 dp 数组
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
