import java.util.HashMap;
import java.util.Map;

/**
 * @author CD
 * @date 11/11/2024
 * @description
 */
public class Code437_PathSumIII {

    // 树节点定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int pathSum(TreeNode root, int targetSum) {
        // 哈希表存储前缀和及其出现次数
        //Map<Integer, Integer> prefixSumCount = new HashMap<>();
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // 初始前缀和为0

        return dfs(root, targetSum, 0L, prefixSumCount);
    }

    // 深度优先搜索函数
    private static int dfs(TreeNode node, int targetSum, Long currSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        // 更新当前路径和
        currSum += node.val;

        // 计算目标路径数目
        int count = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 更新当前路径和在哈希表中的出现次数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 递归搜索左右子节点
        count += dfs(node.left, targetSum, currSum, prefixSumCount);
        count += dfs(node.right, targetSum, currSum, prefixSumCount);

        // 回溯：恢复哈希表中当前路径和的出现次数
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return count;
    }


}
