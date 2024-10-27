/**
 * @author CD
 * @date 10/21/2024
 * @description
 */
public class Code238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 1. 计算左侧乘积
        result[0] = 1;  // 初始化左侧第一个元素为1，因为其左侧没有任何元素
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];  // 左侧乘积 = 前一个元素的左侧乘积 * 前一个元素
        }

        // 2. 计算右侧乘积并将结果累积到结果数组中
        int right = 1;  // 初始化右侧乘积为1，因为最右边的元素右侧没有元素
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;  // 当前结果 = 左侧乘积 * 右侧乘积
            right = right * nums[i];  // 更新右侧乘积
        }

        return result;
    }

}
