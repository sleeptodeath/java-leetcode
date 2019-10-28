public class Solution {
    // 解法一
    public boolean isValidSudoku(char[][] board) {
        // 行
        boolean[][] rows = new boolean[9][9];
        // 列
        boolean[][] cols = new boolean[9][9];
        // 3*3内部 3*(i/3) + j
        boolean[][] cells = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.') {
                    int tmp = board[i][j] - '1';
                    if (rows[i][tmp] || cols[j][tmp] || cells[3*(i/3)+j/3][tmp])
                        return false;
                    rows[i][tmp] = true;
                    cols[j][tmp] = true;
                    cells[3*(i/3)+j/3][tmp] = true;
                }
            }
        }
        return true;
    }

    // 解法二，省空间
//     public boolean isValidSudoku(char[][] board) {
//         Set<String> set = new HashSet<>();

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 // 行 i(num), 列 (num)j, cell i/3(num)j/3
//                 if (board[i][j] != '.') {
//                     String tmp =  "("+ board[i][j] + ")";
//                     if (set.contains(i+tmp) || set.contains(tmp+j) || set.contains(i/3 + tmp + j/3))
//                         return false;
//                     set.add(i+tmp);
//                     set.add(tmp+j);
//                     set.add(i/3 + tmp + j/3);
//                 }
//             }
//         }
//         return true;
//     }
}