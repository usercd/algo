/**
 * @author CD
 * @date 11/17/2024
 * @description
 */
public class Code494_TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        // 计算数组的总和
        for (int num : nums) {
            sum += num;
        }
        // 如果 sum + target 是奇数或者 target 绝对值大于 sum，则无解
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int subsetSum = (sum + target) / 2;
        // 动态规划数组
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // 和为 0 的子集只有一个（空子集）

        // 遍历数组，更新 dp 数组
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}
