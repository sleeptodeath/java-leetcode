import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new LinkedList<>();
        int[] rows = new int[n];
        Arrays.fill(rows,-1);

        boolean[] cols = new boolean[n];
        boolean[] lu = new boolean[2*n];
        boolean[] ru = new boolean[2*n];

        helper(ret, rows, cols, lu, ru, 0, n);
        return ret;
    }

    public void helper(List<List<String>> ret, int[] rows, boolean[] cols, boolean[] lu, boolean[] ru, int row, int n) {
        if (row == n) {
            List<String> tmp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char[] c = new char[n];
                Arrays.fill(c, '.');
                c[rows[i]] = 'Q';
                tmp.add(new String(c));
            }
            ret.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i] || lu[row-i+n-1] || ru[row+i])
                continue;
            rows[row] = i;
            cols[i] = true;
            lu[row-i+n-1] = true;
            ru[row+i] = true;
            helper(ret, rows, cols, lu, ru, row+1, n);
            cols[i] = false;
            lu[row-i+n-1] = false;
            ru[row+i] = false;
        }
    }
}