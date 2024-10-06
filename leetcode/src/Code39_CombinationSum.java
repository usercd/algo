import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @date 9/20/2024
 * package: PACKAGE_NAME
 * class: Code39_CombinationSum
 */
public class Code39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(candidates, target, 0, combination, result);
        return result;
    }

    // 回溯函数
    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        // 目标值为 0，说明找到一个有效组合
        if (target == 0) {
            result.add(new ArrayList<>(combination));  // 将组合加入结果集
            return;
        }

        // 遍历候选数组
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {  // 剪枝：如果当前数字小于等于剩余目标值
                combination.add(candidates[i]);  // 选择当前数字
                // 继续递归：当前数字可以重复使用，所以继续从 i 开始
                backtrack(candidates, target - candidates[i], i, combination, result);
                combination.remove(combination.size() - 1);  // 回溯，撤销选择
            }
        }
    }
}

