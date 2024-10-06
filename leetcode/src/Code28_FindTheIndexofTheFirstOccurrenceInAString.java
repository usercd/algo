/**
 * @author CD
 * @since 4/11/2024 2:54 PM
 * package: PACKAGE_NAME
 * class: Code28_FindTheIndexofTheFirstOccurrenceInAString
 */
public class Code28_FindTheIndexofTheFirstOccurrenceInAString {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
            for (int i = 0; i + m <= n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
}
