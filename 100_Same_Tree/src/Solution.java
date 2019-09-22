import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q!= null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
    // 非递归
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            TreeNode y = queue.poll();
            if (x == null && y == null) {
                continue;
            } else if (x == null || y == null || x.val != y.val) {
                return false;
            } else {
                queue.add(x.left);
                queue.add(y.left);
                queue.add(x.right);
                queue.add(y.right);
            }
        }
        return true;
    }
}
