
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null)
//            return null;
//
//        ListNode H = new ListNode(0);
//        H.next = head;
//        ListNode p = head, q= null;
//        int len = 0;
//        while (p != null) {
//            len++;
//            p = p.next;
//        }
//        len -= n;
//        q = head;
//        p = H;
//        while (len-->0) {
//            q = q.next;
//            p = p.next;
//        }
//        p.next = q.next;
//        return H.next;
//    }

    // one pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode H = new ListNode(0);
        H.next = head;
        ListNode p = H, q = H;

        while (n-- > 0 ) {
            p = p.next;
        }
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        return H.next;
    }
}
