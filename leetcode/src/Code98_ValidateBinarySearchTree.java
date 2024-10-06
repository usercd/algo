/**
 * @author CD
 * @date 10/4/2024
 * @description
 */

public class Code98_ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // 验证二叉搜索树的主函数
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    // 辅助递归函数，用于验证每个节点是否在合法范围内
    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true; // 空节点是合法的BST
        }

        // 检查当前节点是否在 [low, high] 范围内
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false; // 如果不在范围内，直接返回false
        }

        // 递归验证左子树，更新上界为当前节点的值
        // 递归验证右子树，更新下界为当前节点的值
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
