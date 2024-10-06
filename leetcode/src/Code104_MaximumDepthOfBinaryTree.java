import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CD
 * @since 2023/2/5 20:23
 * package: PACKAGE_NAME
 * class: Code104_MaximumDepthOfBinaryTree
 */
public class Code104_MaximumDepthOfBinaryTree {

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

    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 迭代
    // 计算二叉树的最大深度（迭代法，BFS）
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0; // 空树深度为0

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 根节点入队
        int depth = 0; // 记录深度

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            depth++; // 每遍历一层，深度加1

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // 取出当前节点

                // 将左子节点入队（如果存在）
                assert currentNode != null;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // 将右子节点入队（如果存在）
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return depth; // 返回最大深度
    }
}
