/**
 * @author CD
 * @date 11/23/2024
 * @description
 */
public class Code617_MergeTwoBinaryTrees {

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

    /**
     * 合并两棵二叉树
     *
     * @param root1 第一棵树的根节点
     * @param root2 第二棵树的根节点
     * @return 合并后的新树的根节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果 root1 为空，直接返回 root2
        if (root1 == null) {
            return root2;
        }

        // 如果 root2 为空，直接返回 root1
        if (root2 == null) {
            return root1;
        }

        // 创建一个新节点，值为两节点值之和
        TreeNode merged = new TreeNode(root1.val + root2.val);
        // 递归合并左子树和右子树
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
}
