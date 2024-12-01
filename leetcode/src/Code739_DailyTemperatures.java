import java.util.Stack;

/**
 * @author CD
 * @date 11/25/2024
 * @description
 */
public class Code739_DailyTemperatures {
    /**
     * 计算每天等待多少天才能等到更高的气温
     *
     * @param temperatures 气温数组
     * @return 等待天数的数组
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // 结果数组，默认为0
        Stack<Integer> stack = new Stack<>(); // 单调栈，存储索引

        // 遍历每一天的气温
        for (int i = 0; i < n; i++) {
            // 当前气温比栈顶所指气温高
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // 弹出栈顶索引
                answer[prevIndex] = i - prevIndex; // 计算天数差
            }
            // 当前索引入栈
            stack.push(i);
        }

        return answer;
    }
}
