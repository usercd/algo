import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CD
 * @date 9/25/2024
 * package: PACKAGE_NAME
 * class: Code56_MergeIntervals
 */
public class Code56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 如果输入数组为空，直接返回空数组
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // 按照每个区间的起始值进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        // 初始化第一个区间
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的起始值小于等于上一个区间的结束值，则重叠，进行合并
            if (intervals[i][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // 没有重叠，将当前区间加入结果集
                merged.add(currentInterval);
                currentInterval = intervals[i];  // 更新当前区间
            }
        }

        // 将最后一个区间加入结果集
        merged.add(currentInterval);

        // 将 List 转换为二维数组返回
        return merged.toArray(new int[merged.size()][]);
    }
}
