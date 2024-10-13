/**
 * @author CD
 * @date 10/8/2024
 * @description
 */
public class Code124_BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 全局变量，用于记录最大路径和
    private int maxSum = Integer.MIN_VALUE;

    // 主函数：计算二叉树的最大路径和
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;  // 返回最大路径和
    }

    // 辅助递归函数：返回节点对父节点的最大贡献值
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左子树和右子树的最大贡献值
        int leftGain = Math.max(helper(node.left), 0);  // 如果左子树的贡献值为负，直接取 0
        int rightGain = Math.max(helper(node.right), 0);  // 如果右子树的贡献值为负，直接取 0

        // 当前节点的最大路径和为：节点值 + 左子树最大贡献值 + 右子树最大贡献值
        int currentPathSum = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum = Math.max(maxSum, currentPathSum);

        // 返回当前节点能提供给父节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
