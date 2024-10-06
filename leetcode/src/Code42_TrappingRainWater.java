/**
 * @author CD
 * @date 9/22/2024
 * package: PACKAGE_NAME
 * class: Code42_TrappingRainWater
 */
public class Code42_TrappingRainWater {

    // 法一：双指针
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;  // 左右指针
        int leftMax = 0;
        int rightMax = 0;            // 记录左右两侧的最大高度
        int water = 0;               // 结果：存储总的积水量

        while (left < right) {
            if (height[left] < height[right]) {
                // 更新左边最大值，如果当前高度比最大值小则积水
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;  // 移动左指针
            } else {
                // 更新右边最大值，如果当前高度比最大值小则积水
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;  // 移动右指针
            }
        }

        return water;
    }

    // 法二：DP
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];   // 存储每个位置左侧的最大高度
        int[] rightMax = new int[n];  // 存储每个位置右侧的最大高度

        // 预处理左侧最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 预处理右侧最大高度
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 计算积水量
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}
