
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    // 非递归
//    public ListNode swapPairs(ListNode head) {
//        ListNode root = new ListNode(0);
//        root.next = head;
//
//        ListNode p = root;
//        while (p.next != null && p.next.next != null) {
//            ListNode tmp = p.next;
//            p.next = p.next.next;
//            tmp.next = p.next.next;
//            p.next.next = tmp;
//            p = p.next.next;
//        }
//        return root.next;
//    }
    // 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode tmp = head.next;
        head.next = swapPairs(tmp.next);
        tmp.next = head;
        return tmp;
    }
}
