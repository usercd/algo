import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CD
 * @date 10/19/2024
 * @description
 */
public class Code226_InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归反转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; // 如果当前节点为空，直接返回
        }

        // 递归反转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 交换左右子树
        root.left = right;
        root.right = left;

        return root; // 返回反转后的根节点
    }

    // 迭代反转二叉树（BFS）
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 创建一个队列用于广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // 取出当前节点

            // 交换左右子树
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // 将左右子节点加入队列
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }
}
