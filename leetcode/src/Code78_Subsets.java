import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @date 9/29/2024
 * package: PACKAGE_NAME
 * class: Code78_Subsets
 */
public class Code78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // 每次调用时都添加当前子集
        result.add(new ArrayList<>(current));

        // 遍历可能的元素
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // 包含当前元素
            backtrack(result, current, nums, i + 1); // 递归
            current.remove(current.size() - 1); // 不包含当前元素，回溯
        }
    }
}
