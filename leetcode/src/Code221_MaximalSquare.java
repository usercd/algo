/**
 * @author CD
 * @date 10/18/2024
 * @description
 */
public class Code221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        // 定义dp数组，dp[i][j]表示以(i,j)为右下角的最大正方形边长
        int[][] dp = new int[rows][cols];
        int maxSide = 0;  // 记录最大正方形的边长

        // 遍历每个元素
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // 第一行或第一列时，只能是1
                    } else {
                        // 动态规划递推公式
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    // 更新最大边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // 返回最大正方形的面积
        return maxSide * maxSide;
    }
}
