/**
 * @author CD
 * @date 9/26/2024
 * package: PACKAGE_NAME
 * class: Code70_ClimbingStairs
 */
public class Code70_ClimbingStairs {

    public int climbStairs(int n) {
        // 特殊情况处理
        if (n == 1) return 1;

        // 创建一个数组 dp 来存储每个台阶的方式数
        int[] dp = new int[n + 1];

        // 基础情况
        dp[1] = 1;  // 只有一种方式到达第一个台阶
        dp[2] = 2;  // 两种方式到达第二个台阶：1+1 或 2

        // 填充 dp 数组
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // 状态转移方程
        }

        return dp[n];  // 返回到达第 n 个台阶的方式数
    }

    public int climbStairs2(int n) {
        // 特殊情况处理
        if (n == 1) return 1;

        // 初始化前两个台阶的方式数
        int first = 1;  // dp[1]
        int second = 2; // dp[2]
        int current = 0;

        // 从第 3 个台阶开始计算
        for (int i = 3; i <= n; i++) {
            current = first + second;  // 当前台阶的方式数
            first = second;  // 更新 first 为第二个台阶的方式数
            second = current; // 更新 second 为当前台阶的方式数
        }

        return second;  // 返回到达第 n 个台阶的方式数
    }

}
