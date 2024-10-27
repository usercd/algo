import java.util.Arrays;

/**
 * @author CD
 * @date 10/23/2024
 * @description
 */
public class Code279_PerfectSquares {

    // 法一 DP
    public int numSquares(int n) {
        // dp[i] 表示将数字 i 表示为完全平方数和所需的最少个数
        int[] dp = new int[n + 1];

        // 初始化，最多的情况是每个数字都由 1 构成
        Arrays.fill(dp, n + 1);
        dp[0] = 0; // 0 不需要任何数字

        // 填充 dp 数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 更新 dp[i]，尝试减去一个完全平方数 j^2
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    // 法二 DFS
    // 最少完全平方数的个数，初始化为一个很大的值
    private int minSquares = Integer.MAX_VALUE;

    // 主函数，找到将 n 分解为最少的完全平方数个数
    public int numSquares2(int n) {
        // 调用辅助函数进行递归搜索
        findMinSquares(n, 0);
        return minSquares; // 返回结果
    }

    // 递归辅助函数，n 为当前剩余的数，count 为当前已使用的完全平方数个数
    private void findMinSquares(int remaining, int count) {
        // 如果当前计数已经大于等于当前最小值，直接返回，剪枝
        if (count >= minSquares) {
            return;
        }

        // 如果剩余数为 0，表示找到一个有效组合，更新最小值
        if (remaining == 0) {
            minSquares = count;
            return;
        }

        // 找出小于等于 remaining 的最大完全平方数
        int maxSquareRoot = (int) Math.sqrt(remaining);

        // 从最大平方数开始递减搜索
        for (int i = maxSquareRoot; i > 0; i--) {
            int square = i * i; // 计算平方数
            int quotient = remaining / square; // 当前平方数的使用次数

            // 如果当前组合的数量已经超过最小值，则剪枝
            if (quotient + count >= minSquares) {
                return;
            }

            // 递归调用，继续减去平方数并增加计数
            findMinSquares(remaining - square, count + 1);
        }
    }

    // 法三 四平方定理
    public int numSquares3(int n) {
        // 如果 n 是一个完全平方数，直接返回 1
        if (isPerfectSquare(n)) {
            return 1;
        }

        // 如果 n 满足 4^k * (8m + 7) 的形式，返回 4
        if (checkAnswer4(n)) {
            return 4;
        }

        // 检查是否可以由两个完全平方数相加构成
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }

        // 否则返回 3
        return 3;
    }

    // 判断一个数是否是完全平方数
    private boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    // 判断是否能表示为 4^k * (8m + 7)
    private boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
