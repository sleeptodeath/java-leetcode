
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(3);

        solution.deleteDuplicates(list);

        printList(list);

    }
    public static void printList(ListNode list) {

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
