import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int left, int right) {
        List<TreeNode> ret = new LinkedList<>();

        if (left > right) {
            ret.add(null);
            return ret;
        }

        for (int i = left; i <= right; i++) {
            // 求左边和右边的树
            List<TreeNode> leftSub = helper(left, i-1);
            List<TreeNode> rightSub = helper(i+1, right);

            for (TreeNode leftSubNode: leftSub) {
                for (TreeNode rightSubNode: rightSub) {
                    // 左边*右边的笛卡尔积
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = leftSubNode;
                    tmp.right = rightSubNode;
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }

}