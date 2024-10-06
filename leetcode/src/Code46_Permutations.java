import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @date 9/22/2024
 * package: PACKAGE_NAME
 * class: Code46_Permutations
 */
public class Code46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];  // 标记数字是否被使用
        backtrack(nums, current, used, result);
        return result;
    }

    // 回溯函数
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // 当排列的长度等于 nums 数组的长度时，说明找到一个有效排列
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));  // 将当前排列加入结果集
            return;
        }

        // 遍历所有可能的选择
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经被使用，则跳过
            if (used[i]) {
                continue;
            }

            // 选择当前数字，并标记为已使用
            current.add(nums[i]);
            used[i] = true;

            // 递归处理下一个位置
            backtrack(nums, current, used, result);

            // 回溯，撤销选择
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
