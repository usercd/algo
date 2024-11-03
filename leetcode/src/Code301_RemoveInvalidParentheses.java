import java.util.*;

/**
 * @author CD
 * @date 10/28/2024
 * @description
 */
public class Code301_RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();  // 记录已访问的字符串，避免重复处理
        Queue<String> queue = new LinkedList<>();  // 用于进行广度优先搜索
        queue.add(s);
        visited.add(s);
        boolean found = false;  // 表示是否找到至少一个有效表达式
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            // 如果找到有效表达式，则停止进一步的删除操作
            if (found) continue;
            // 否则，生成所有去掉一个括号的子字符串
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                String next = current.substring(0, i) + current.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return result;
    }

    // 检查表达式是否有效
    private static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;  // 右括号过多
            }
        }
        return count == 0;  // 若最终计数不为0，说明左括号过多
    }

}
