import java.util.Stack;

/**
 * @author CD
 * @date 11/4/2024
 * @description
 */
public class Code394_DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();  // 用于存储重复次数
        Stack<StringBuilder> stringStack = new Stack<>();  // 用于存储子字符串
        StringBuilder currentString = new StringBuilder();  // 当前解析的字符串
        int k = 0;  // 当前数字

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 如果是数字，更新重复次数 k
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // 遇到 '['，将当前重复次数和字符串推入栈
                countStack.push(k);
                stringStack.push(currentString);
                // 重置 currentString 和 k
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // 遇到 ']'，将栈顶字符串弹出并重复 countStack 顶次数
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // 遇到字母，加入当前字符串
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

}
