/**
 * @author CD
 * @date 11/1/2024
 * @description
 */
public class Code338_CountingBits {
    public static int[] countBits(int n) {
        int[] counts = new int[n + 1];  // 用于存储每个数字的1的个数
        counts[0] = 0;  // 初始化，0 的1的个数为0

        for (int i = 1; i <= n; i++) {
            counts[i] = counts[i >> 1] + (i & 1);  // 根据 i 的奇偶性更新 counts[i]
        }

        return counts;
    }
}
