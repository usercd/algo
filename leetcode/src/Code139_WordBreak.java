import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author CD
 * @date 10/9/2024
 * @description
 */
public class Code139_WordBreak {

    // 主函数，判断字符串 s 能否被拆分为字典中的单词
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典转换为 HashSet 以加快查找速度
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i] 表示字符串 s 的前 i 个字符能否被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // 空字符串可以被拆分

        // 遍历字符串 s，计算 dp 数组
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 如果 s 的前 j 个字符可以拆分，并且 s[j:i] 在字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // 一旦找到可以拆分的方式，直接跳出循环
                }
            }
        }

        // 返回 dp[s.length()]，即整个字符串是否可以拆分
        return dp[s.length()];
    }
}
