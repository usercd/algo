/**
 * @author CD
 * @date 11/22/2024
 * @description
 */
public class Code581_ShortestUnsortedContinuousSubarray {
    /**
     * 找到最短的无序子数组的长度
     *
     * @param nums 输入数组
     * @return 无序子数组的长度
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        // 初始化左右边界
        int left = -1, right = -1;

        // 用于记录遍历过程中的最大值和最小值
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // 从左向右遍历，寻找右边界
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                right = i;
            }
        }

        // 从右向左遍历，寻找左边界
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                left = i;
            }
        }

        // 如果没有无序区域，返回 0
        if (left == -1) {
            return 0;
        }

        // 返回无序子数组的长度
        return right - left + 1;
    }
}
