import java.util.Stack;

/*

 */
public class Solution {

//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null)
//            return false;
//        if (root.left == null && root.right == null) // 叶子节点
//            return root.val == sum;
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum-root.val);
//    }

    //
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        path.push(root);
        sums.push(root.val);
        while (!path.isEmpty()) {
            TreeNode tmp = path.pop();
            int val = sums.pop();
            if (tmp.left == null && tmp.right == null) {
                if (val == sum)
                    return true;
            }
            if (tmp.left != null) {
                path.push(tmp.left);
                sums.push(val + tmp.left.val);
            }
            if (tmp.right != null) {
                path.push(tmp.right);
                sums.push(val + tmp.right.val);
            }

        }
        return false;
    }
}
