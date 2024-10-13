/**
 * @author CD
 * @date 10/9/2024
 * @description
 */
public class Code136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
