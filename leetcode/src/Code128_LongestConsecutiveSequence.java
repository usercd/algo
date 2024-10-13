import java.util.HashSet;
import java.util.Set;

/**
 * @author CD
 * @date 10/8/2024
 * @description
 */
public class Code128_LongestConsecutiveSequence {

    // 主函数：找到最长的连续序列长度
    public int longestConsecutive(int[] nums) {
        // 将所有元素加入哈希集合
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;  // 用于记录最长连续序列长度

        // 遍历数组
        for (int num : numSet) {
            // 只有当前数是连续序列的起点时才进行计算
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 找到该起点的最长连续序列
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // 更新最长序列长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;  // 返回最长连续序列的长度
    }
}
