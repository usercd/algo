/**
 * @author CD
 * @date 9/23/2024
 * package: PACKAGE_NAME
 * class: Code48_RotateImage
 */
public class Code48_RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 先对矩阵进行转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 交换 matrix[i][j] 和 matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 再将矩阵的每一行进行反转
        for (int i = 0; i < n; i++) {
            // 反转每一行
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
