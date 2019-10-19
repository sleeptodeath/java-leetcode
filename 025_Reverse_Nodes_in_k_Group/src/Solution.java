import java.util.List;
import java.util.Stack;

class  ListNode {
    int val;
    ListNode next;
    public  ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;

        int t = k;
        while (tmp != null && t-->0) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        // 不足k个
        if (t > 0) {
            return head;
        }

        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while (!stack.isEmpty()) {
            ListNode q = stack.pop();
            p.next = q;
            p = p.next;
        }

        p.next = reverseKGroup(tmp, k);
        return ret.next;
    }
}
