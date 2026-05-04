public class LinkedListCycle {
    public class ListNode {
        int data;
        ListNode next;

        ListNode(int ele) {
            this.data = ele;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle list = new LinkedListCycle();
        ListNode head = list.new ListNode(1);
        ListNode second = list.new ListNode(2);
        ListNode third = list.new ListNode(3);
        ListNode fourth = list.new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = third; // Creates a cycle

        System.out.println(list.hasCycle(head)); // Output: true}
    }
}
