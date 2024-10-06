import java.util.HashMap;

/**
 * @author CD
 * @date 9/28/2024
 * package: PACKAGE_NAME
 * class: Code76_MinimumWindowSubstring
 */
public class Code76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        HashMap<Character, Integer> tCount = new HashMap<>();
        // 统计 t 中每个字符的出现次数
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // t 中不同字符的数量
        int required = tCount.size();
        // 当前窗口中满足 t 中字符数量的字符数量
        int formed = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        // 滑动窗口的左右指针
        int left = 0, right = 0;
        // 最小子串的长度
        int minLength = Integer.MAX_VALUE;
        // 最小子串的左边界
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口，添加右侧字符
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            // 如果当前字符的数量达到 t 中的数量
            if (tCount.containsKey(c) && windowCounts.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }
            // 收缩窗口，直到不再满足条件
            while (left <= right && formed == required) {
                c = s.charAt(left);
                // 更新最小子串
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                // 移除左侧字符
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tCount.containsKey(c) && windowCounts.get(c) < tCount.get(c)) {
                    formed--; // 不再满足条件
                }
                left++; // 移动左指针
            }

            right++; // 移动右指针
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    // 优化：使用数组代替 HashMap
    public String minWindow2(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        // Array to store the frequency of characters in t
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        int required = t.length(); // Total number of characters we need to match
        int formed = 0; // Number of characters currently matched
        int[] windowCounts = new int[128]; // Array to store the frequency of characters in the current window
        int left = 0, right = 0; // Pointers for the sliding window
        int minLength = Integer.MAX_VALUE; // Length of the minimum window
        int minLeft = 0; // Left boundary of the minimum window

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts[c]++; // Add the current character to the window

            // If the current character is in t and its count in the window is less than or equal to its count in t
            if (tCount[c] > 0 && windowCounts[c] <= tCount[c]) {
                formed++;
            }

            // Try to contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                windowCounts[c]--; // Remove the character at the left pointer from the window
                // If the current character is in t and its count in the window is less than its count in t
                if (tCount[c] > 0 && windowCounts[c] < tCount[c]) {
                    formed--;
                }
                left++; // Move the left pointer to the right
            }
            right++; // Move the right pointer to the right
        }
        // Return the minimum window or an empty string if no such window exists
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

}
