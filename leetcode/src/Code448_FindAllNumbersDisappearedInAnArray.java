import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @date 11/13/2024
 * @description
 */
public class Code448_FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // 遍历数组，将对应索引位置的值标记为负数
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // 计算数字对应的索引位置
            if (nums[index] > 0) {
                nums[index] = -nums[index];  // 将对应位置的值变为负数，标记该数字已出现
            }
        }
        // 再次遍历数组，找出所有值为正数的索引位置，这些位置对应的数字即为缺失的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);  // 对应的数字是 i + 1
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        //首先标记没有出现的数字
        boolean[] exists = new boolean[n + 1];
        for (int num : nums) {
            exists[num] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!exists[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
