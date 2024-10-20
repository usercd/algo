import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author CD
 * @date 10/16/2024
 * @description
 */
public class Code207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建一个入度数组，用于记录每个课程的前置课程数量
        int[] inDegree = new int[numCourses];
        // 邻接表用于记录每个课程的后续课程
        List<List<Integer>> adjList = new ArrayList<>();

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // 填充入度数组和邻接表
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            // 当前课程的前置课程数+1
            inDegree[course]++;
            // 将前置课程放入邻接表中
            adjList.get(prereqCourse).add(course);
        }

        // 使用队列来存放所有入度为0的课程，表示可以学习的课程
        Queue<Integer> queue = new LinkedList<>();

        // 将所有入度为0的课程入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 已完成课程计数
        int completedCourses = 0;

        // BFS遍历所有可以学习的课程
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;

            // 遍历当前课程的后续课程
            for (int nextCourse : adjList.get(currentCourse)) {
                inDegree[nextCourse]--;  // 当前后续课程的前置课程数-1
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);  // 如果前置课程数为0，则可以学习，加入队列
                }
            }
        }

        // 如果完成的课程数等于课程总数，说明可以完成所有课程
        return completedCourses == numCourses;
    }

}
