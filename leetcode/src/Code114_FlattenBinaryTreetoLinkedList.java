import java.util.Stack;

/**
 * @author CD
 * @date 10/7/2024
 * @description
 */
public class Code114_FlattenBinaryTreetoLinkedList {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 法一 递归
    // 将二叉树展平为单链表的递归函数
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 递归展平左子树和右子树
        flatten(root.left);
        flatten(root.right);

        // 保存右子树
        TreeNode tempRight = root.right;

        // 将左子树插入到右子树的位置
        root.right = root.left;
        root.left = null;  // 将左子树置为空

        // 找到右子树的最右端
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // 将原来的右子树接到右子树的最右端
        current.right = tempRight;
    }

    // 法二 迭代
    // 使用栈来进行前序遍历，并原地展开二叉树
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // 如果当前节点有右子树，压入栈中
            if (current.right != null) {
                stack.push(current.right);
            }

            // 如果当前节点有左子树，压入栈中
            if (current.left != null) {
                stack.push(current.left);
            }

            // 重新构造右子树
            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;  // 将左子树置为空
        }
    }


}
