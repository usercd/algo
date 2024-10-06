/**
 * @author CD
 * @date 9/15/2024
 * package: PACKAGE_NAME
 * class: Code31_NextPermutation
 */
public class Code31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;
        int i = n - 2;

        // Step 1: 从右往左找到第一个下降的元素，nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: 如果找到了这样的元素
        if (i >= 0) {
            // Step 3: 从右往左找到第一个比 nums[i] 大的元素
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Step 4: 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // Step 5: 反转 nums[i+1] 之后的元素
        reverse(nums, i + 1, n - 1);
    }

    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反转数组中从 start 到 end 的元素
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
