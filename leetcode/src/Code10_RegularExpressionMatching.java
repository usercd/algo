/**
 * @author CD
 * @since 9/4/2024 9:41 AM
 * package: PACKAGE_NAME
 * class: Code10_RegularExpressionMatching
 * Description:
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class Code10_RegularExpressionMatching {

    // dp
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] 表示 s 的前 i 个字符 s[0..i) 和 p 的前 j 个字符 p[0..j) 是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始状态，空字符串与空模式串是匹配的
        dp[0][0] = true;

        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    // 判断 s 的第 i 个字符和 p 的第 j 个字符是否匹配
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    // GPT
    public boolean isMatch2(String s, String p) {
        int m = s.length();  // 字符串 s 的长度
        int n = p.length();  // 模式串 p 的长度

        // dp[i][j] 表示 s 的前 i 个字符 s[0..i) 和 p 的前 j 个字符 p[0..j) 是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始状态，空字符串与空模式串是匹配的
        dp[0][0] = true;

        // 处理空字符串与模式串的匹配情况
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // 如果模式串的第 j 个字符是 '*'，那么它可以匹配模式串的前一个字符出现 0 次
                // 所以我们看去掉 p[j-2] 和 p[j-1] 后的子模式是否匹配空字符串
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {  // 遍历字符串 s 的每个字符
            for (int j = 1; j <= n; j++) {  // 遍历模式串 p 的每个字符

                // 情况 1: 当前字符匹配（即 p[j-1] == s[i-1]）或者 p[j-1] 是通配符 '.'
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];  // 当前字符匹配，继承之前的状态
                }
                // 情况 2: 当前字符是 '*'
                else if (p.charAt(j - 1) == '*') {
                    // '*' 代表前一个字符出现 0 次, 比如 'a*' 可以看作空字符
                    dp[i][j] = dp[i][j - 2];

                    // '*' 代表前一个字符出现 1 次或多次, 比如 'a*' 中的 'a' 与 s[i-1] 匹配
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        // 最终结果，字符串 s[0..m) 是否与模式串 p[0..n) 匹配
        return dp[m][n];
    }

}
