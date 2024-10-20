/**
 * @author CD
 * @date 10/20/2024
 * @description
 */
public class Code236_LowestCommonAncestorOfABinaryTree {
    // 定义二叉树节点类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 查找二叉树中两个节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，返回 null
        if (root == null) {
            return null;
        }
        // 如果当前节点是 p 或 q，返回当前节点
        if (root == p || root == q) {
            return root;
        }
        // 在左子树中查找 p 和 q 的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中查找 p 和 q 的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果 p 和 q 分别在当前节点的左右子树中，则当前节点就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 否则，如果左子树中找到结果，返回左子树的结果；如果右子树中找到结果，返回右子树的结果
        return left != null ? left : right;
    }
}
