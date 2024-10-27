import java.util.Deque;
import java.util.LinkedList;

/**
 * @author CD
 * @date 10/21/2024
 * @description
 */
public class Code239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        // 存放结果的数组，长度为 nums.length - k + 1
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        // 使用双端队列，存储元素的索引，保证队列中的元素按递减顺序排列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 1. 移除不在窗口范围内的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 2. 移除队列中所有小于当前元素的元素，它们不再可能成为最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 3. 将当前元素的索引加入队列
            deque.offerLast(i);
            // 4. 当窗口大小达到k时，记录结果
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

}
