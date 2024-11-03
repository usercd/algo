/**
 * @author CD
 * @date 10/31/2024
 * @description
 */
public class Code337_HouseRobberIII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    // 返回一个长度为 2 的数组，res[0] 表示不抢当前节点的最大金额，res[1] 表示抢当前节点的最大金额
    private static int[] robSub(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        // 当前节点不抢，左右子节点可以自由选择抢或不抢
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // 当前节点抢，左右子节点只能选择不抢
        int rob = node.val + left[0] + right[0];

        return new int[]{noRob, rob};
    }
}
