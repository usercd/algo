import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @since 9/9/2024 8:49 AM
 * package: PACKAGE_NAME
 * class: Code17_LetterCombinationsofaPhoneNumber
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 */
public class Code17_LetterCombinationsofaPhoneNumber {
    // 数字到字母的映射表
    private static final String[] KEYPAD = {
            "",     // 0 没有对应的字母
            "",     // 1 没有对应的字母
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;  // 如果输入为空，返回空列表
        }

        // 调用回溯函数进行组合生成
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    // 回溯法核心函数
    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // 如果已经处理完所有的数字，当前组合完成
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母集
        String letters = KEYPAD[digits.charAt(index) - '0'];

        // 遍历每个字母，尝试加入当前组合
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // 选择当前字母
            backtrack(result, current, digits, index + 1);  // 递归处理下一个数字
            current.deleteCharAt(current.length() - 1);  // 回溯，移除最后添加的字母
        }
    }

}
