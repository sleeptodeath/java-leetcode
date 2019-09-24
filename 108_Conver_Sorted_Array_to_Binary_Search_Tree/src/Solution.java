/**
 * 二叉搜索树
 * 左边都比根节点小
 * 右边都比根节点大
 *
 * 可以用递归
 * 中间元素当根节点
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/ 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid-1);
        node.right = helper(nums, mid+1, right);
        return node;
    }
}
