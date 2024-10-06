/**
 * @author CD
 * @since 9/2/2024 7:43 PM
 * package: PACKAGE_NAME
 * class: Code05_LongestPalindromicSubstring
 */

// Given a string `s`, return the longest palindromic substring in `s`.

public class Code05_LongestPalindromicSubstring {
    // 法一 动态规划
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 回文串的起始位置
        int begin = 0;
        // 回文串的最大长度
        int maxLen = 1;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 填充dp数组
        for (int j = 1; j < len; j++) { // j是子串结束位置
            for (int i = 0; i < j; i++) { // i是子串起始位置
                if (s.charAt(i) == s.charAt(j)) { // 如果s[i] == s[j]
                    if (j - i < 3) { // 如果子串长度小于等于3，直接判断为回文
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1]; // 否则，依赖于内部子串的状态
                    }
                } else {
                    dp[i][j] = false; // s[i] != s[j]时，不是回文
                }

                // 如果s[i...j]是回文且长度大于maxLength，更新最长回文子串的位置和长度
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    // 法二 中心扩展
    public String longestPalindrome2(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度回文
            int len1 = expandAroundCenter(s, i, i);
            // 偶数长度回文
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        // 返回回文串的长度
        return right - left - 1;
    }

    // 法三 Manacher 算法
    public String longestPalindrome3(String s) {
        // 如果字符串为空，返回空字符串
        if (s == null || s.isEmpty()) return "";
        // 预处理字符串
        String T = preprocessString(s);
        int n = T.length();
        // P数组，记录以每个位置为中心的最长回文半径
        int[] P = new int[n];
        // 初始化中心C和右边界R
        int C = 0;
        int R = 0;
        for (int i = 1; i < n - 1; i++) {
            // i' = 2*C - i, i' 是 i 关于中心C的对称位置
            int mirr = 2 * C - i;
            // 如果i在R的范围内，使用对称性初始化P[i]
            if (R > i) {
                P[i] = Math.min(R - i, P[mirr]);
            }
            // 尝试扩展以i为中心的回文串
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            // 如果扩展后的回文右边界超过了当前R，更新C和R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        // 找到P数组的最大值，计算出对应的回文子串
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        // 通过中心索引和最大长度来提取原始字符串中的最长回文子串
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // 辅助方法：预处理字符串，插入特殊字符
    private String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^'); // 开始符，防止越界
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        sb.append('$'); // 结束符，防止越界
        return sb.toString();
    }
}
