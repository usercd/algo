/**
 * @author CD
 * @date 9/24/2024
 * package: PACKAGE_NAME
 * class: Code53_MaximumSubarray
 */
public class Code53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // 初始化当前子数组的最大和和全局最大和
        int currentMax = nums[0];
        int globalMax = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 更新当前子数组的最大和
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // 更新全局最大和
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;  // 返回全局最大和
    }
}
