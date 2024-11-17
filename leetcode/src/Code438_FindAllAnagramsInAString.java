import java.util.ArrayList;
import java.util.List;

/**
 * @author CD
 * @date 11/12/2024
 * @description
 */
public class Code438_FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        // 用于记录 p 中各字符的频率
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        // 用于记录当前窗口中各字符的频率
        int[] sCount = new int[26];
        // 初始化窗口
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        // 滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 检查当前窗口是否是字母异位词
            if (matches(pCount, sCount)) {
                result.add(i - p.length());
            }
            // 窗口右移：移出左边字符，加入右边字符
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
        }
        // 检查最后一个窗口
        if (matches(pCount, sCount)) {
            result.add(s.length() - p.length());
        }
        return result;
    }

    // 检查两个计数数组是否相等
    private static boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) return false;
        }
        return true;
    }
}
