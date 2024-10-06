import java.util.Arrays;
import java.util.HashMap;

/**
 * @author CD
 * @since 2023/2/5 20:31
 * package: PACKAGE_NAME
 * class: Code105_ConstructBinaryTreeFromPreorderAndInorderTraversal
 */
public class Code105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    // 哈希表存储中序遍历中每个节点的索引
    private HashMap<Integer, Integer> inorderIndexMap;

    // 主函数：根据前序和中序遍历构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建哈希表，快速定位中序遍历中的根节点位置
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // 调用递归构造二叉树
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    // 辅助函数：递归构造二叉树
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        // 递归结束条件：如果区间为空，返回 null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历的第一个节点就是当前子树的根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 根节点在中序遍历中的索引
        int rootIndex = inorderIndexMap.get(rootVal);

        // 计算左子树的节点数量
        int leftSize = rootIndex - inStart;

        // 递归构造左子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);

        // 递归构造右子树
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);

        // 返回当前构造的树节点
        return root;
    }

}
