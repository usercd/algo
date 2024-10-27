/**
 * @author CD
 * @date 10/24/2024
 * @description
 */
public class Code287_FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // 使用快慢指针查找环的起点，即重复数字
        int slow = nums[0];
        int fast = nums[0];

        // 快慢指针，快指针每次走两步，慢指针走一步
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 找到环的入口，也就是重复的数字
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
