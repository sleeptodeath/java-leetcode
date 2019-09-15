
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        printListNode(solution.mergeTwoLists(null, l2));

    }

    public static void printListNode(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

}
