import java.util.HashMap;

/**
 * @author CD
 * @date 11/21/2024
 * @description
 */
public class Code560_SubarraySumEqualsK {
    /**
     * 找出和为 k 的子数组的个数
     *
     * @param nums 整数数组
     * @param k    目标和
     * @return 子数组的个数
     */
    public int subarraySum(int[] nums, int k) {
        // 使用哈希表记录前缀和及其出现次数
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // 初始化前缀和为 0 的情况，表示没有子数组时前缀和为 0

        int count = 0; // 记录满足条件的子数组个数
        int sum = 0;   // 当前的前缀和

        // 遍历数组
        for (int num : nums) {
            sum += num; // 更新当前前缀和

            // 检查是否存在前缀和满足条件
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            // 更新当前前缀和的出现次数
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
