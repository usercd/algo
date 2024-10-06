import java.util.HashMap;
import java.util.Map;

/**
 * @author CD
 * @since 7/31/2024 3:43 PM
 * package: hot100
 * class: Code01_TwoSum
 * description:
 * Given an array of integers `nums` and an integer `target`,
 * return indices of the two numbers such that they add up to `target`.
 * You may assume that each input would have **exactly one solution**,
 * and you may not use the same element twice.You can return the answer in any order.
 */

public class Code01_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("不存在这样的两个数");
    }
}
