import java.util.*;

/**
 * @author CD
 * @date 11/3/2024
 * @description
 */
public class Code347_TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: 使用哈希表统计频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: 使用最小堆存储频率前 k 高的元素
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // 移除频率最低的元素
            }
        }

        // Step 3: 提取结果并转换为 int[]
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;  // 返回 int[]
    }
}
