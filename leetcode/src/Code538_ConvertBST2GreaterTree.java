/**
 * @author CD
 * @date 11/18/2024
 * @description
 */
public class Code538_ConvertBST2GreaterTree {

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

    // 全局变量，用于记录累加和
    private int sum = 0;

    /**
     * 将给定的二叉搜索树转换为累加树
     *
     * @param root 二叉搜索树的根节点
     * @return 转换后的累加树的根节点
     */
    public TreeNode convertBST(TreeNode root) {
        // 调用递归函数进行转换
        traverse(root);
        return root;
    }

    /**
     * 反向中序遍历，更新每个节点的值
     *
     * @param node 当前节点
     */
    private void traverse(TreeNode node) {
        if (node == null) {
            return; // 递归终止条件
        }

        // 1. 先递归遍历右子树
        traverse(node.right);

        // 2. 更新当前节点的值
        sum += node.val;      // 累加当前节点值到全局变量
        node.val = sum;       // 更新当前节点值为累加和

        // 3. 再递归遍历左子树
        traverse(node.left);
    }
}


