
/*
    判断左子树和右子树的高度差是否超过1
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int l = helper(root.left);
        if (l == -1)
            return -1;
        int r = helper(root.right);
        if (r == -1)
            return -1;
        if (Math.abs(l-r) <= 1)
            return Math.max(l, r) + 1;
        else
            return -1;
    }

}
