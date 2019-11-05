public class Solution {
    public void rotate(int[][] matrix) {
        // 先转置
        T(matrix);
        int n = matrix[0].length;

        // 交换
        for (int i = 0, j = n-1; i < j; i++,j--) {
            for (int k = 0; k < n; k++) {
                swap(matrix, k, i, k, j);
            }
        }

    }

    public void T(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                swap(matrix, i, j, j , i);
            }
        }
    }

    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

}