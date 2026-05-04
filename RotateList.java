// Rotate List: Leetcode Problem 61
public class RotateList {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode rotateListNode(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length; // Handle cases where k is greater than length
        if (k == 0)
            return head;
        tail.next = head; // Connect tail to head to make it circular
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        RotateList rl = new RotateList();
        ListNode head = rl.new ListNode(1);
        head.next = rl.new ListNode(2);
        head.next.next = rl.new ListNode(3);
        head.next.next.next = rl.new ListNode(4);
        head.next.next.next.next = rl.new ListNode(5);
        int k = 2; // Rotate right by 2 positions
        ListNode newHead = rl.rotateListNode(head, k);
        System.out.print("Rotated list: ");
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}
