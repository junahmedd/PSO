// Middle of the Linked List: Leetcode Problem 876
public class MiddleList {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode middleListNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleList ml = new MiddleList();
        ListNode head = ml.new ListNode(1);
        head.next = ml.new ListNode(2);
        head.next.next = ml.new ListNode(3);
        head.next.next.next = ml.new ListNode(4);
        head.next.next.next.next = ml.new ListNode(5);
        ListNode middle = ml.middleListNode(head);
        System.out.println("Middle node data: " + middle.data);
    }
}
