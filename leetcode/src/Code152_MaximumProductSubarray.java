/**
 * @author CD
 * @date 10/13/2024
 * @description
 */
public class Code152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        // 边界条件，数组为空
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化最大乘积和最小乘积都为第一个元素
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // 如果当前元素为负数，交换最大和最小乘积
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // 计算以当前元素结尾的最大值和最小值
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            // 更新全局最大乘积
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
