/**
 * @author CD
 * @date 10/27/2024
 * @description
 */
public class Code300_LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        // tails 数组，存储每个长度的递增子序列的最小结尾元素
        int[] tails = new int[nums.length];
        int size = 0; // 当前递增子序列的长度

        for (int num : nums) {
            // 二分查找：在 tails 数组中寻找 >= num 的第一个元素的位置
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 更新 tails 数组
            tails[left] = num;
            if (left == size) size++; // 若 num 增加了递增序列的长度
        }
        return size;
    }
}
