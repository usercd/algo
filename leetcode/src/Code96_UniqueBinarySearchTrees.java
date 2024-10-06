/**
 * @author CD
 * @date 10/4/2024
 * @description
 */
public class Code96_UniqueBinarySearchTrees {
    // 计算不同二叉搜索树的数量
    public int numTrees(int n) {
        // 定义动态规划数组，dp[i] 表示长度为 i 的序列能构成的二叉搜索树个数
        int[] dp = new int[n + 1];

        // 初始化
        dp[0] = 1; // 空树情况
        dp[1] = 1; // 单节点树

        // 开始动态规划，自底向上填充 dp 数组
        for (int i = 2; i <= n; i++) { // 计算 dp[i]
            for (int j = 1; j <= i; j++) { // j 作为根节点
                dp[i] += dp[j - 1] * dp[i - j]; // 左子树为 j-1 个节点，右子树为 i-j 个节点
            }
        }

        return dp[n]; // 返回长度为 n 的序列可以构成的不同二叉搜索树的数量
    }
}
