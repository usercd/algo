/**
 * @author CD
 * @date 9/20/2024
 * package: PACKAGE_NAME
 * class: Code34_FindFirstAndLastPositionOfElementinSortedArray
 */
public class Code34_FindFirstAndLastPositionOfElementinSortedArray {
    // 主函数，调用两个二分查找函数
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);  // 查找第一个位置
        result[1] = findLast(nums, target);   // 查找最后一个位置
        return result;
    }

    // 查找目标值第一次出现的位置
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;  // 初始化为 -1，表示未找到目标值
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;  // 向左搜索
            } else {
                left = mid + 1;   // 向右搜索
            }
            if (nums[mid] == target) {
                index = mid;  // 更新目标值位置
            }
        }
        return index;
    }

    // 查找目标值最后一次出现的位置
    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;  // 初始化为 -1，表示未找到目标值
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;   // 向右搜索
            } else {
                right = mid - 1;  // 向左搜索
            }
            if (nums[mid] == target) {
                index = mid;  // 更新目标值位置
            }
        }
        return index;
    }
}
