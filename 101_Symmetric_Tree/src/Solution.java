import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    // DFS
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    // BFS
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        if (root == null)
//            return true;
//
//        queue.add(root.left);
//        queue.add(root.right);
//
//        while (!queue.isEmpty()) {
//            TreeNode x = queue.poll();
//            TreeNode y = queue.poll();
//
//            if (x == null && y == null)
//                continue;
//            if (x == null || y == null)
//                return false;
//            if (x.val != y.val)
//                return false;
//            queue.add(x.left);
//            queue.add(y.right);
//            queue.add(x.right);
//            queue.add(y.left);
//
//        }
//        return true;
//    }
}
