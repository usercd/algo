import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author CD
 * @date 10/18/2024
 * @description
 */
public class Code215_KthLargestElementInAnArray {

    // 法一 小根堆
    // 使用最小堆来找第k大的元素
    public int findKthLargest(int[] nums, int k) {
        // 创建一个大小为k的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // 遍历数组，将元素加入到堆中
        for (int num : nums) {
            minHeap.offer(num); // 插入元素到最小堆
            if (minHeap.size() > k) {
                minHeap.poll(); // 当堆的大小超过k时，移除堆顶元素（最小的元素）
            }
        }

        // 返回堆顶元素，它就是第k大的元素
        return minHeap.peek();
    }

    // 法二 快速选择
    public int findKthLargest2(int[] nums, int k) {
        // 我们要找到第 n-k 小的元素
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // 快速选择算法
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {  // 如果数组只剩一个元素，直接返回
            return nums[left];
        }

        // 随机选择一个枢轴，并将其分区
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);

        // 分区，并获取分区后的枢轴位置
        pivotIndex = partition(nums, left, right, pivotIndex);

        // 如果枢轴位置就是我们要找的位置，直接返回
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            // 如果枢轴位置小于目标位置，递归右边
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            // 如果枢轴位置大于目标位置，递归左边
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    // 分区函数：类似快速排序的分区
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        // 将枢轴移到右边
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // 将所有小于枢轴值的元素移到左边
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        // 将枢轴移回正确的位置
        swap(nums, storeIndex, right);

        return storeIndex;
    }

    // 交换函数
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
