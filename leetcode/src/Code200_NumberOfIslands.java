import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CD
 * @date 10/15/2024
 * @description
 */
public class Code200_NumberOfIslands {

    // 法一 深度优先搜索(DFS)解决岛屿数量问题
    // 主方法，计算岛屿数量
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0; // 记录岛屿数量
        int rows = grid.length;
        int cols = grid[0].length;

        // 遍历每个网格位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果当前网格是陆地
                if (grid[i][j] == '1') {
                    numIslands++; // 找到一个新的岛屿
                    dfs(grid, i, j); // 启动DFS，将该岛屿的所有陆地标记为已访问
                }
            }
        }

        return numIslands;
    }

    // 深度优先搜索(DFS)方法，用于标记岛屿
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 判断边界条件，越界或遇到水（'0'）时停止递归
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // 将当前陆地标记为已访问（变为'0'）
        grid[i][j] = '0';

        // 递归处理四个方向
        dfs(grid, i - 1, j); // 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }

    // 法二 BFS
    // 使用广度优先搜索（BFS）方法
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向

        // 遍历每个网格位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果当前网格是陆地
                if (grid[i][j] == '1') {
                    numIslands++; // 找到一个新的岛屿
                    grid[i][j] = '0'; // 将该陆地标记为已访问

                    // 使用队列进行BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0], y = point[1];

                        // 遍历四个方向
                        for (int[] direction : directions) {
                            int newX = x + direction[0];
                            int newY = y + direction[1];

                            // 如果新位置在边界内，并且是陆地，加入队列并标记为已访问
                            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1') {
                                queue.offer(new int[]{newX, newY});
                                grid[newX][newY] = '0'; // 标记为已访问
                            }
                        }
                    }
                }
            }
        }

        return numIslands;
    }

}
