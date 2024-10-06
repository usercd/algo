import java.util.Stack;

/**
 * @author CD
 * @date 9/18/2024
 * package: PACKAGE_NAME
 * class: Code32_LongestValidParentheses
 * description:
 * Given a string containing just the characters
 * '(' and ')', return the length
 * of the longest valid (well-formed) parentheses substring
 */

public class Code32_LongestValidParentheses {
    // 法一：用栈
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // 初始化栈，放入一个初始索引-1，帮助计算长度
        int maxLength = 0;

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 如果是左括号，将索引压入栈中
                stack.push(i);
            } else {
                // 如果是右括号，弹出栈顶元素
                stack.pop();

                if (stack.isEmpty()) {
                    // 如果栈空，说明无法匹配，将当前索引压入栈
                    stack.push(i);
                } else {
                    // 否则，计算有效子串长度
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    // 法二：DP
    public int longestValidParentheses2(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];

        // 遍历字符串
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 情况1: "()", 当前子串长度 = dp[i-2] + 2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 情况2: "))(..)", 当前子串长度 = dp[i-1] + dp[i-dp[i-1]-2] + 2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                // 更新最大长度
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }
}
