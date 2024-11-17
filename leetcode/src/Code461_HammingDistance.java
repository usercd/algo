/**
 * @author CD
 * @date 11/14/2024
 * @description
 */
public class Code461_HammingDistance {
    // 计算两个数的汉明距离
    public static int hammingDistance(int x, int y) {
        // 对 x 和 y 进行异或运算，得到不同位的二进制表示
        int xor = x ^ y;
        // 统计异或结果中 1 的个数
        int count = 0;
        //Brian Kernighan 算法统计一个数的二进制1的个数
        while (xor != 0) {
            // 每次将 xor 的最低位的 1 置为 0
            xor &= (xor - 1);
            count++;  // 增加 1，表示一个不同位
        }
        return count;
    }
}
