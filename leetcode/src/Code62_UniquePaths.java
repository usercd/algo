/**
 * @author CD
 * @date 9/25/2024
 * package: PACKAGE_NAME
 * class: Code62_UniquePaths
 */
public class Code62_UniquePaths {

    public int uniquePaths(int m, int n) {
        // 创建一个 m x n 的 dp 数组
        int[][] dp = new int[m][n];

        // 填充第一行和第一列，只有一种路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;  // 从第一列只能向下移动
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;  // 从第一行只能向右移动
        }

        // 填充 dp 数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];  // 当前格的路径数等于上方和左方的路径数之和
            }
        }

        return dp[m - 1][n - 1];  // 返回右下角的路径数
    }
}
