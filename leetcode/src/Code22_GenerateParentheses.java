import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @date 9/13/2024
 * package: PACKAGE_NAME
 * class: Code22_GenerateParentheses
 * Given n pairs of parentheses,
 * write a function to generate
 * all combinations of well-formed parentheses.
 */
public class Code22_GenerateParentheses {

    // 回溯法
    public List<String> generateParenthesis(int n) {
        // 用于存储所有的括号组合结果
        List<String> result = new ArrayList<>();
        // 调用回溯函数进行组合生成
        backtrack(result, new StringBuilder(), n, n);
        return result;
    }

    // 回溯函数
    private void backtrack(List<String> result, StringBuilder current, int left, int right) {
        // 当左右括号都已经用完，意味着找到了一个合法组合
        if (left == 0 && right == 0) {
            result.add(current.toString());
            return;
        }

        // 如果还有左括号可以使用，递归放一个左括号
        if (left > 0) {
            current.append('('); // 选择放置一个左括号
            backtrack(result, current, left - 1, right); // 递归
            current.deleteCharAt(current.length() - 1); // 回溯，撤销选择
        }

        // 如果右括号数量多于左括号，可以放置右括号
        if (right > left) {
            current.append(')'); // 选择放置一个右括号
            backtrack(result, current, left, right - 1); // 递归
            current.deleteCharAt(current.length() - 1); // 回溯，撤销选择
        }
    }
}
