/**
 * @author CD
 * @date 10/24/2024
 * @description
 */
public class Code283_MoveZeroes {

    public static void moveZeroes(int[] nums) {
        // 用于记录非零元素应该放置的位置
        int nonZeroIndex = 0;

        // 遍历数组，遇到非零元素时，将其移动到nonZeroIndex的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // 将剩余的位置全部填充为0
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
