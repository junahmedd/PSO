// Remove Nth Node From End of List: Leetcode Problem 19
public class RemoNthFromNode {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            if (fast == null)
                return dummy.next; // n > length, no removal
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoNthFromNode rnfn = new RemoNthFromNode();
        ListNode head = rnfn.new ListNode(1);
        head.next = rnfn.new ListNode(2);
        head.next.next = rnfn.new ListNode(3);
        head.next.next.next = rnfn.new ListNode(4);
        head.next.next.next.next = rnfn.new ListNode(5);
        int n = 2; // Remove the 2nd node from the end
        ListNode newHead = rnfn.removeNthFromEnd(head, n);
        System.out.print("List after removal: ");
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}
