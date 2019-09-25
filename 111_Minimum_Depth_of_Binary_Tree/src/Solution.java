
import java.util.LinkedList;
import java.util.Queue;

/*
    最小深度： 从root到叶子节点的最小路径长
    methodA: 按层遍历,找叶子节点
    methodB: 深搜
 */
public class Solution {
    // BFS
//    public int minDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        int cnt = 1;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                TreeNode tmp = queue.poll();
//                if (tmp.left == null && tmp.right == null) // 是叶子节点
//                    return cnt;
//                if (tmp.left != null)
//                    queue.add(tmp.left);
//                if (tmp.right != null)
//                    queue.add(tmp.right);
//            }
//            cnt++;
//        }
//        return cnt;
//    }

    // DFS
    /*
        如果左子树和右子树都不为空 返回 min(l_depth, r_depth) + 1
        如果左子树为空, 返回 1 + r_depth
        如果右子树为空, 返回 1 + r_depth
        都为空： 返回1
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        //
        int l_depth = minDepth(root.left);
        int r_depth = minDepth(root.right);

        if (root.left != null && root.right != null)
            return Math.min(l_depth, r_depth) + 1;
        else
            return 1 + l_depth + r_depth;

    }
}
