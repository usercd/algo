/**
 * @author CD
 * @date 9/27/2024
 * package: PACKAGE_NAME
 * class: Code75_SortColors
 */
public class Code75_SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;   // 记录下一个 0 的位置
        int twoIndex = nums.length - 1; // 记录下一个 2 的位置
        int currentIndex = 0; // 当前扫描的位置

        while (currentIndex <= twoIndex) {
            if (nums[currentIndex] == 0) {
                // 当前是 0，交换到 zeroIndex 位置，并移动两个指针
                swap(nums, currentIndex, zeroIndex);
                zeroIndex++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                // 当前是 2，交换到 twoIndex 位置，移动 twoIndex
                swap(nums, currentIndex, twoIndex);
                twoIndex--;
                // 不移动 currentIndex，因为需要检查交换后的新值
            } else {
                // 当前是 1，直接移动 currentIndex
                currentIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
