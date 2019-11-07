import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new LinkedList<>();
        if (matrix.length == 0)
            return ret;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int r = 0, c = 0, di = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int i = 0; i < m * n; i++) {
            ret.add(matrix[r][c]);
            seen[r][c] = true;
            int nr = r + dr[di];
            int nc = c + dc[di];
            if (nr >= 0 && nr < m && nc >=0 && nc < n && !seen[nr][nc]) {
                r = nr;
                c = nc;
            } else {
                di = (di+1)%4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ret;
    }

    // 分层
//     public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> ret = new LinkedList<>();
//         if (matrix.length == 0)
//             return ret;
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int r1 = 0, r2 = m-1;
//         int c1 = 0, c2 = n-1;

//         while (r1 <= r2 && c1 <= c2) {
//             for (int i = c1; i <= c2; i++) {
//                 ret.add(matrix[r1][i]);
//             }
//             for (int i = r1+1; i <= r2; i++) {
//                 ret.add(matrix[i][c2]);
//             }
//             if (r1 < r2) {
//                 for (int i = c2-1; i >= c1; i--) {
//                     ret.add(matrix[r2][i]);
//                 }
//             }
//             if (c1 < c2) {
//                 for (int i = r2-1; i > r1; i--) {
//                     ret.add(matrix[i][c1]);
//                 }
//             }
//             r1++;
//             c1++;
//             r2--;
//             c2--;
//         }
//         return ret;
//     }
}