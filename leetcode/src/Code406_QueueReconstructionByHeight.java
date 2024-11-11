import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CD
 * @date 11/7/2024
 * @description
 */
public class Code406_QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {
        // Step 1: 排序，身高降序，若身高相同按 k 升序
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        // Step 2: 结果列表
        List<int[]> result = new LinkedList<>();

        // Step 3: 按照排序好的数组进行插入
        for (int[] person : people) {
            result.add(person[1], person);  // 在位置 k 插入元素
        }

        // Step 4: 将结果转化为数组返回
        return result.toArray(new int[people.length][2]);
    }

}
