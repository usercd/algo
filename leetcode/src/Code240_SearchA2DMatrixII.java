/**
 * @author CD
 * @date 10/22/2024
 * @description
 */
public class Code240_SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 检查输入矩阵是否为空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 获取矩阵的行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从矩阵的右上角开始搜索
        int row = 0;
        int col = cols - 1;

        // 当当前元素在矩阵范围内时，继续搜索
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // 找到目标值
            } else if (matrix[row][col] > target) {
                col--; // 如果当前值大于目标值，向左移动
            } else {
                row++; // 如果当前值小于目标值，向下移动
            }
        }

        // 如果没有找到，返回false
        return false;
    }

}
