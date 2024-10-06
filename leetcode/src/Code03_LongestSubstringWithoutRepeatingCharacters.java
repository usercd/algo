import java.util.HashSet;
import java.util.Set;

/**
 * @author CD
 * @since 7/31/2024 4:56 PM
 * package: hot100
 * class: Code03_LongestSubstringWithoutRepeatingCharacters
 */

// Given a string `s`, find the length of the longest substring without repeating characters.

public class Code03_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int cur = -1;
        int ans = 0;
        for (int i = 0; i < length; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (cur + 1 < length && !set.contains(s.charAt(cur + 1))) {
                set.add(s.charAt(cur + 1));
                cur++;
            }
            ans = Math.max(ans, cur - i + 1);
        }
        return ans;
    }

}
