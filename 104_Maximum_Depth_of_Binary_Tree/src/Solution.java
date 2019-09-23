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

    // recursive
//    public int maxDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    // BFS
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
            count++;
        }
        return count;
    }

}
