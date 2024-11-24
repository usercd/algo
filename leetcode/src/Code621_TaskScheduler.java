import java.util.Arrays;

/**
 * @author CD
 * @date 11/24/2024
 * @description
 */
public class Code621_TaskScheduler {
    /**
     * 计算完成所有任务所需的最短时间
     *
     * @param tasks 任务数组，每个任务用一个大写字母表示
     * @param n     冷却时间
     * @return 最短时间
     */
    public int leastInterval(char[] tasks, int n) {
        // 统计每个任务的出现次数
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // 找到出现频率最高的任务
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25]; // 最高频率
        int maxCount = 0; // 出现频率等于 maxFreq 的任务数量
        for (int freq : frequencies) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        // 计算最短时间
        int minTime = (maxFreq - 1) * (n + 1) + maxCount;

        // 返回实际所需时间，取任务总数和计算值的较大值
        return Math.max(minTime, tasks.length);
    }
}
