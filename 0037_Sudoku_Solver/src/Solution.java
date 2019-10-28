public class Solution {

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public boolean helper(char[][] board, int i, int j) {
        if (i >= 9) return true;
        if (j >= 9) return helper(board, i+1, 0);
        if (board[i][j] != '.') return helper(board, i, j+1);

        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, i, j, c))
                continue;
            board[i][j] = c;
            if (helper(board, i, j+1))
                return true;
            board[i][j] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int i, int j, char c) {
        // 行
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c)
                return false;
        }
        // 列
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c)
                return false;
        }
        // cell
        int basex = (i/3)*3;
        int basey = (j/3)*3;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[basex+x][basey+y] == c)
                    return false;
            }
        }
        return true;
    }
}