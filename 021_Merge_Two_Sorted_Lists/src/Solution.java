
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode r = ret;

        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
                r = r.next;
            } else {
                r.next = q;
                r = r.next;
                q = q.next;
            }
        }

        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return ret.next;
    }
}
