public class Solution {

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        // 包括根节点
        int m = depth(root.left) + depth(root.right);
        // 不包括根节点
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(l, r), m);
    }
}
