import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author CD
 * @date 10/2/2024
 * @description
 */

public class Code94_BinaryTreeInorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // 法一 递归
    // 中序遍历函数
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // 结果列表
        inorderHelper(root, result); // 递归遍历
        return result;
    }

    // 递归函数
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) { // 基本条件：如果节点为空，直接返回
            return;
        }
        inorderHelper(node.left, result); // 递归访问左子树
        result.add(node.val);             // 访问根节点
        inorderHelper(node.right, result);// 递归访问右子树
    }

    // 法二 迭代
    // 中序遍历函数（迭代法）
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // 当栈非空或当前节点非空时
        while (current != null || !stack.isEmpty()) {
            // 不断将当前节点的左子节点压入栈
            while (current != null) {
                stack.push(current);
                current = current.left; // 访问左子树
            }

            // 弹出栈顶节点，访问该节点
            current = stack.pop();
            result.add(current.val); // 记录节点值

            // 转向右子树
            current = current.right;
        }

        return result;
    }
}
