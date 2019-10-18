import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    // 题意：合并k个排好序的链表


    // divide and conquer
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        return helper(lists, 0, lists.length-1);
//    }
//
//    public ListNode helper(ListNode[] lists, int left, int right) {
//        if (left >= right) return lists[left];
//        int mid = (left + right) / 2;
//        ListNode ll = helper(lists, left, mid);
//        ListNode lr = helper(lists, mid+1, right);
//        return merge2Lists(ll, lr);
//    }
//
//    public ListNode merge2Lists(ListNode l1, ListNode l2) {
//
//        ListNode ret = new ListNode(0);
//        ListNode cur = ret;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                cur.next = l1;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = l1 != null? l1:l2;
//        return ret.next;
//    }

    // Priority
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        PriorityQueue<ListNode> que = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null)
                que.add(list);
        }

        while (!que.isEmpty()) {
            ListNode tmp = que.poll();
            cur.next = tmp;
            cur = cur.next;
            if (tmp.next != null) {
                que.add(tmp.next);
            }
        }
        return ret.next;
    }
}
