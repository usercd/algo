import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CD
 * @since 2023/2/5 20:10
 * package: PACKAGE_NAME
 * class: Code101_SymmetricTree
 */
public class Code101_SymmetricTree {

    // Definition for a binary tree node.
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


    // 法一 递归
    // 判断二叉树是否是对称的
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // 空树是对称的
        return isMirror(root.left, root.right); // 调用辅助函数比较左右子树
    }

    // 辅助函数，判断两个子树是否是镜像对称的
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; // 两个子树都为空，则是对称的
        if (left == null || right == null) return false; // 一个为空，另一个不为空，不对称
        if (left.val != right.val) return false; // 节点值不相等，不对称

        // 递归判断左子树的左节点与右子树的右节点是否对称，左子树的右节点与右子树的左节点是否对称
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // 法二 迭代
    // 判断二叉树是否对称（迭代法）
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true; // 空树是对称的

        // 初始化队列，用于存储左右子树的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        // 开始迭代
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue; // 都为空，继续
            if (left == null || right == null) return false; // 一个为空，另一个不为空，不对称
            if (left.val != right.val) return false; // 值不相等，不对称

            // 将下一层的左右子节点按顺序入队（左子树的左节点和右子树的右节点，左子树的右节点和右子树的左节点）
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true; // 遍历完成后，没有发现不对称的情况
    }

}
