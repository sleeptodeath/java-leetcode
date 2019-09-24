import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {-10,-3,0,5,9};
        TreeNode root = solution.sortedArrayToBST(arr);
        printTree(root);
    }

    public static void printTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    System.out.println(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }

        }
    }
}
