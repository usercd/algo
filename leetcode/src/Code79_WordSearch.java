/**
 * @author CD
 * @date 9/29/2024
 * package: PACKAGE_NAME
 * class: Code79_WordSearch
 */
public class Code79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 遍历每个字符，尝试找到单词的起始点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true; // 找到单词
                }
            }
        }

        return false; // 未找到单词
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // 如果当前索引等于单词长度，表示找到单词
        if (index == word.length()) {
            return true;
        }

        // 边界检查，确保当前坐标有效且字符匹配
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // 标记当前字符为访问过（避免重复访问）
        char temp = board[row][col];
        board[row][col] = '#'; // 使用 '#' 表示已访问

        // 进行深度优先搜索，探索上下左右
        boolean found = dfs(board, word, row + 1, col, index + 1) || // 向下
                dfs(board, word, row - 1, col, index + 1) || // 向上
                dfs(board, word, row, col + 1, index + 1) || // 向右
                dfs(board, word, row, col - 1, index + 1);   // 向左

        // 恢复当前字符
        board[row][col] = temp; // 恢复原字符

        return found; // 返回结果
    }
}

