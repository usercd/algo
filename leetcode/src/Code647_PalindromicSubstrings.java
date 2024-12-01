/**
 * @author CD
 * @date 11/25/2024
 * @description
 */
public class Code647_PalindromicSubstrings {
    /**
     * 统计回文子串的数量
     *
     * @param s 输入字符串
     * @return 回文子串数量
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // 遍历每个字符，以它为中心扩展
        for (int i = 0; i < n; i++) {
            // 奇数长度的回文中心
            count += countPalindromesFromCenter(s, i, i);
            // 偶数长度的回文中心
            count += countPalindromesFromCenter(s, i, i + 1);
        }

        return count;
    }

    /**
     * 从中心向外扩展，计算以某中心为回文的子串数量
     *
     * @param s     输入字符串
     * @param left  左边界
     * @param right 右边界
     * @return 当前中心的回文子串数量
     */
    private static int countPalindromesFromCenter(String s, int left, int right) {
        int count = 0;

        // 向两边扩展，直到不满足回文条件
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; // 每找到一个回文子串，计数加1
            left--;  // 左指针向左扩展
            right++; // 右指针向右扩展
        }

        return count;
    }
}
