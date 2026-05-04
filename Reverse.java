public class Reverse {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move prev to the current node
            current = nextTemp; // Move to the next node
        }
        return prev; // At the end, prev will be the new head of the reversed list
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        ListNode head = reverse.new ListNode(1);
        head.next = reverse.new ListNode(2);
        head.next.next = reverse.new ListNode(3);
        head.next.next.next = reverse.new ListNode(4);
        head.next.next.next.next = reverse.new ListNode(5);
        ListNode originalHead = head; // Keep a reference to the original head for printing
        System.out.print("Original list: ");
        while (originalHead != null) {
            System.out.print(originalHead.val + " ");
            originalHead = originalHead.next;
        }
        System.out.println();
        ListNode reversedHead = reverse.reverseList(head);
        System.out.print("Reversed list: ");
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}
