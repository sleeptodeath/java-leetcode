public class Solution {

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] lu = new boolean[2*n];
        boolean[] ru = new boolean[2*n];
        return helper(n, 0, cols, lu, ru);
    }

    public int helper(int n, int row, boolean[] cols, boolean[] lu, boolean[] ru) {
        if (row == n)
            return 1;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cols[i] || lu[row-i+n-1] || ru[row+i])
                continue;

            cols[i] = true;
            lu[row-i+n-1] = true;
            ru[row+i] = true;
            cnt += helper(n, row+1, cols, lu, ru);
            cols[i] = false;
            lu[row-i+n-1] = false;
            ru[row+i] = false;

        }
        return cnt;
    }
}