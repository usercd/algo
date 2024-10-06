import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author CD
 * @date 10/5/2024
 * @description
 */

public class Code102_BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 层次遍历二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // 存储最终结果
        if (root == null) return result; // 如果根节点为空，直接返回空列表

        Queue<TreeNode> queue = new LinkedList<>(); // 队列用于层次遍历
        queue.offer(root); // 将根节点入队

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            List<Integer> currentLevel = new ArrayList<>(); // 存储当前层的节点值

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // 取出当前节点
                assert currentNode != null;
                currentLevel.add(currentNode.val); // 将当前节点的值加入当前层的列表

                // 将当前节点的左子节点入队（如果存在）
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // 将当前节点的右子节点入队（如果存在）
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // 将当前层的结果加入最终结果
            result.add(currentLevel);
        }

        return result; // 返回最终结果
    }

}
