/**
 * @author CD
 * @date 9/26/2024
 * package: PACKAGE_NAME
 * class: Code64_MinimumPathSum
 */
public class Code64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;      // 行数
        int n = grid[0].length;   // 列数

        // 创建一个 m x n 的 dp 数组
        int[][] dp = new int[m][n];

        // 初始化 dp 数组的第一格
        dp[0][0] = grid[0][0];

        // 填充第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];  // 只能从左边走来
        }

        // 填充第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];  // 只能从上面走来
        }

        // 填充 dp 数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);  // 当前格的最小路径和
            }
        }

        return dp[m - 1][n - 1];  // 返回右下角的最小路径和
    }
}
