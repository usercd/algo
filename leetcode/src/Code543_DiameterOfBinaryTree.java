/**
 * @author CD
 * @date 11/20/2024
 * @description
 */
public class Code543_DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 全局变量，用于记录最大直径
    private int maxDiameter = 0;

    /**
     * 求二叉树的直径
     *
     * @param root 二叉树的根节点
     * @return 二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // 调用递归函数计算深度，同时更新最大直径
        depth(root);
        return maxDiameter;
    }

    /**
     * 计算以当前节点为根的子树的最大深度
     *
     * @param node 当前节点
     * @return 当前节点的子树深度
     */
    private int depth(TreeNode node) {
        if (node == null) {
            return 0; // 空节点的深度为 0
        }

        // 递归计算左子树和右子树的深度
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // 更新最大直径：左子树深度 + 右子树深度
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 返回当前节点的深度：较大的子树深度 + 1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
