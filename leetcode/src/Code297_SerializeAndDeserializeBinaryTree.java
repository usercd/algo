import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CD
 * @date 10/25/2024
 * @description
 */
public class Code297_SerializeAndDeserializeBinaryTree {

    // 定义二叉树的节点结构
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 序列化：将二叉树转化为字符串（先序遍历）
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // 辅助函数，递归实现先序遍历的序列化
    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");  // 空节点用 "null" 表示
            return;
        }
        sb.append(root.val).append(",");  // 记录当前节点的值
        serializeHelper(root.left, sb);   // 序列化左子树
        serializeHelper(root.right, sb);  // 序列化右子树
    }

    // 反序列化：将字符串转化为二叉树
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");  // 将字符串按逗号分隔
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.offer(node);
        }
        return deserializeHelper(queue);
    }

    // 辅助函数，递归实现反序列化
    private static TreeNode deserializeHelper(Queue<String> queue) {
        String node = queue.poll();
        assert node != null;
        if ("null".equals(node)) {
            return null;  // 空节点，返回 null
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));  // 创建当前节点
        root.left = deserializeHelper(queue);  // 反序列化左子树
        root.right = deserializeHelper(queue); // 反序列化右子树
        return root;
    }
}
