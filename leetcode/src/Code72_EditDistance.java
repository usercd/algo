/**
 * @author CD
 * @date 9/27/2024
 * package: PACKAGE_NAME
 * class: Code72_EditDistance
 */
public class Code72_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 创建一个 (m+1) x (n+1) 的 dp 数组
        int[][] dp = new int[m + 1][n + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // 将 word1 的前 i 个字符转换为空字符串需要 i 次删除
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // 将空字符串转换为 word2 的前 j 个字符需要 j 次插入
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // 字符相同，不需要操作
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));  // 计算删除、插入和替换
                }
            }
        }

        return dp[m][n];  // 返回将 word1 转换为 word2 的最小操作次数
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 创建一个长度为 n + 1 的一维数组
        int[] dp = new int[n + 1];

        // 初始化 dp 数组
        for (int j = 0; j <= n; j++) {
            dp[j] = j;  // 将空字符串转换为 word2 的前 j 个字符需要 j 次插入
        }

        // 遍历 word1 的每个字符
        for (int i = 1; i <= m; i++) {
            int prev = dp[0];  // 保存上一个 dp[i-1][j] 的值
            dp[0] = i;  // 将 word1 的前 i 个字符转换为空字符串需要 i 次删除
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];  // 保存当前 dp[i][j] 的值
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;  // 字符相同，不需要操作
                } else {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j - 1], prev));  // 计算删除、插入和替换
                }
                prev = temp;  // 更新 prev 为当前的 dp[i][j]
            }
        }

        return dp[n];  // 返回将 word1 转换为 word2 的最小操作次数
    }
}
