/**
 * @author CD
 * @date 10/15/2024
 * @description
 */
public class Code198_HouseRobber {

    // 法一：递归解决House Robber问题
    // 动态规划解决House Robber问题
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // 如果房屋数组为空，返回0
        }
        if (nums.length == 1) {
            return nums[0]; // 只有一间房屋时，直接返回该房屋的金额
        }

        // 初始化dp数组，存储每个状态的最大金额
        int[] dp = new int[nums.length];

        // 基本情况：第0间房屋的最大金额就是偷窃它
        dp[0] = nums[0];

        // 第二间房屋的最大金额是偷窃较多的那间房
        dp[1] = Math.max(nums[0], nums[1]);

        // 从第3间房屋开始，计算每间房的最大偷窃金额
        for (int i = 2; i < nums.length; i++) {
            // 当前最大偷窃金额是偷当前房屋和偷前两间房屋的最大值，或不偷当前房屋
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // 返回最后一间房屋的最大偷窃金额
        return dp[nums.length - 1];
    }

    // 法二 空间复杂度优化到O(1)
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 使用两个变量保存前两个状态
        int prev2 = nums[0]; // 相当于dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // 相当于dp[i-1]

        // 从第3间房屋开始计算
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]); // 当前最大值
            prev2 = prev1; // 更新dp[i-2]
            prev1 = curr;  // 更新dp[i-1]
        }

        return prev1; // 最终返回prev1
    }

}
