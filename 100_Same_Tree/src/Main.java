
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
//        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
//        q.right = new TreeNode(3);
        q.right = new TreeNode(2);
        System.out.println(solution.isSameTree1(p, q));
    }
}
