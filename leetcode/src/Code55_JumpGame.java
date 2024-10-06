/**
 * @author CD
 * @date 9/24/2024
 * package: PACKAGE_NAME
 * class: Code55_JumpGame
 */
public class Code55_JumpGame {

    public boolean canJump(int[] nums) {
        int farthest = 0;  // 当前能到达的最远位置
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 如果当前位置超出了当前能到达的最远位置，返回 false
            if (i > farthest) {
                return false;
            }
            // 更新最远位置
            farthest = Math.max(farthest, i + nums[i]);
            // 如果能到达或超过最后一个索引，返回 true
            if (farthest >= n - 1) {
                return true;
            }
        }

        return false;  // 遍历结束后仍未能到达最后一个索引
    }

}
