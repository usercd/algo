/**
 * @author CD
 * @since 9/5/2024 4:00 PM
 * package: PACKAGE_NAME
 * class: Code11_ContainerWithMostWater
 * description: Given n non-negative integers a1, a2, ..., an
 * where each represents a point at coordinate (i, ai).
 */
public class Code11_ContainerWithMostWater {
    // 双指针
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
