public class Solution {

    // 模拟
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];

        boolean[][] seen = new boolean[n][n];
        int r = 0, c = 0, di = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int i = 1; i <= n * n; i++) {
        ret[r][c] = i;
        seen[r][c] = true;
        int nr = r + dr[di];
        int nc = c + dc[di];
        if (nr >= 0 && nr < n && nc >=0 && nc < n && !seen[nr][nc]) {
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
        // 按层
//     public int[][] generateMatrix(int n) {
//         int[][] ret = new int[n][n];

//         int r1 = 0, r2 = n-1;
//         int c1 = 0, c2 = n-1;
//         int num = 1;
//         while (r1 <= r2 && c1 <= c2) {
//             for (int i = c1; i <= c2; i++) {
//                 ret[r1][i] = num++;
//             }
//             for (int i = r1+1; i <= r2; i++) {
//                 ret[i][c2] = num++;
//             }
//             if (r1 < r2) {
//                 for (int i = c2-1; i >= c1; i--) {
//                     ret[r2][i] = num++;
//                 }
//             }
//             if (c1 < c2) {
//                 for (int i = r2-1; i > r1; i--) {
//                     ret[i][c1] = num++;
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