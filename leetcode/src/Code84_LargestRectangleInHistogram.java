import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author CD
 * @date 9/30/2024
 * package: PACKAGE_NAME
 * class: Code84_LargestRectangleInHistogram
 */
public class Code84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        // 辅助栈，用于存储柱子的索引
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0; // 用于存储最大矩形面积
        int n = heights.length;

        // 遍历每个柱子
        for (int i = 0; i < n; i++) {
            // 当栈非空且当前柱子高度小于栈顶柱子高度时，计算矩形面积
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()]; // 栈顶柱子的高度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // 矩形宽度
                maxArea = Math.max(maxArea, h * width); // 更新最大矩形面积
            }
            // 当前柱子入栈
            stack.push(i);
        }

        // 处理栈中剩余的柱子
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * width);
        }

        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

        int n = heights.length;
        int maxArea = 0;

        // 创建一个新的数组，在两端添加高度为 0 的哨兵
        int[] extendedHeights = new int[n + 2];
        extendedHeights[0] = 0;
        extendedHeights[n + 1] = 0;

        // 复制原数组的内容到新数组中
        System.arraycopy(heights, 0, extendedHeights, 1, n);

        // 使用双端队列存储柱子下标
        Deque<Integer> indexStack = new ArrayDeque<>();
        indexStack.addLast(0);  // 第一个哨兵的下标

        // 遍历数组
        for (int i = 1; i < extendedHeights.length; i++) {
            // 如果当前高度小于栈顶元素的高度，则计算以栈顶元素为高的最大矩形面积
            while (extendedHeights[indexStack.peekLast()] > extendedHeights[i]) {
                int height = extendedHeights[indexStack.pollLast()];
                int width = i - indexStack.peekLast() - 1;  // 当前柱子与栈顶元素之间的宽度
                maxArea = Math.max(maxArea, height * width);
            }
            indexStack.addLast(i);
        }

        return maxArea;
    }

}
