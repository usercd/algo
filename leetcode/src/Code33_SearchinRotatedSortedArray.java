/**
 * @author CD
 * @date 9/19/2024
 * package: PACKAGE_NAME
 * class: Code33_SearchinRotatedSortedArray
 */
public class Code33_SearchinRotatedSortedArray {
    // 二分
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 找到目标值，返回索引
            if (nums[mid] == target) {
                return mid;
            }

            // 判断哪一部分是有序的
            if (nums[left] <= nums[mid]) {
                // 左半部分是有序的
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // 目标值在左半部分
                } else {
                    left = mid + 1;   // 目标值不在左半部分，搜索右半部分
                }
            } else {
                // 右半部分是有序的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // 目标值在右半部分
                } else {
                    right = mid - 1;  // 目标值不在右半部分，搜索左半部分
                }
            }
        }

        // 未找到目标值，返回 -1
        return -1;
    }
}
