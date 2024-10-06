import java.util.Stack;

/**
 * @author CD
 * @date 10/2/2024
 * @description
 */
public class Code85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // 边界检查
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] heights = new int[matrix[0].length]; // 用于存储每一行的高度

        // 遍历每一行
        for (char[] chars : matrix) {
            // 更新当前行的高度数组
            for (int j = 0; j < matrix[0].length; j++) {
                // 如果当前是 '1'，高度累加，否则高度重置为 0
                heights[j] = chars[j] == '1' ? heights[j] + 1 : 0;
            }

            // 计算当前高度下的最大矩形面积
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // 利用柱状图计算最大矩形面积
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // 如果当前高度小于栈顶高度，则计算以栈顶为高度的矩形面积
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()]; // 栈顶柱子的高度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // 矩形宽度
                maxArea = Math.max(maxArea, h * width); // 更新最大矩形面积
            }
            stack.push(i); // 当前索引入栈
        }

        // 处理剩余栈中的柱子
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * width);
        }

        return maxArea;
    }
}
