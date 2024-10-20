/**
 * @author CD
 * @date 10/14/2024
 * @description
 */
public class Code169_MajorityElement {

    // 使用摩尔投票算法找到多数元素
    public int majorityElement(int[] nums) {
        // 候选元素和计数器
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // 当计数为0时，选择当前元素作为候选人
            }
            // 如果当前元素等于候选人，增加计数，否则减少计数
            count += (num == candidate) ? 1 : -1;
        }

        // 返回多数元素，因为题目中已保证多数元素存在
        return candidate;
    }

    public int majorityElement2(int[] nums) {
        int res = select(nums, 0);
        return nums[res];
    }

    private int select(int[] nums, int curr) {
        int count = 1;
        int next = curr + 1;
        while (next < nums.length) {
            if (nums[next] == nums[curr]) {
                count++;
            } else {
                count--;
            }
            next++;
            if (count == 0) {
                return select(nums, next);
            }
        }
        return curr;
    }

}
