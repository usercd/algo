import java.util.*;

/**
 * @author CD
 * @date 9/23/2024
 * package: PACKAGE_NAME
 * class: Code49_GroupAnagrams
 */
public class Code49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 使用 HashMap 来存储异位词组，key 为排序后的字符串，value 为异位词列表
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 将字符串排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // 如果排序后的字符串已经存在于 map 中，直接将当前字符串加入该列表
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        // 将所有的异位词组返回为列表
        return new ArrayList<>(map.values());
    }
}
