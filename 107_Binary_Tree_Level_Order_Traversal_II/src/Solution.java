import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    BFS
    按层遍历

    DFS
    深搜，记录深度，在相应的层插入
 */
public class Solution {

    // BFS
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> ret = new LinkedList<>();
//
//        if (root == null)
//            return ret;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            List<Integer> list = new LinkedList<>();
//            int size = queue.size();
//
//            while (size-- > 0) {
//                TreeNode tmp = queue.poll();
//
//                if (tmp.left != null) queue.add(tmp.left);
//                if (tmp.right != null) queue.add(tmp.right);
//                list.add(tmp.val);
//            }
//            ret.add(0, list);
//        }
//        return ret;
//    }

    // DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper(list, root, 1);
        return list;
    }

    public void helper(List<List<Integer>> sublist, TreeNode root, int level) {
        if (root == null) return;
        if (sublist.size() < level)
            sublist.add(0, new LinkedList<>());
        sublist.get(sublist.size() - level).add(root.val);
        helper(sublist, root.left, level+1);
        helper(sublist, root.right, level+1);
    }
}
