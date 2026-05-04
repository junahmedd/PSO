public class ReverseBetweenTest {

    // 1. The static ListNode class
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    // 2. Your Solution class
    public static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) return head;
            
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            
            for (int i = 0; i < left - 1; i++) prev = prev.next;
            
            ListNode curr = prev.next;
            
            for (int i = 0; i < right - left; i++) {
                ListNode nodeToMove = curr.next;
                curr.next = nodeToMove.next;
                nodeToMove.next = prev.next;
                prev.next = nodeToMove;
            }
            
            return dummy.next;
        }
    }

    // 3. The Helper Method for easy printing
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 4. The Main Method
    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print Original
        System.out.print("Original list: ");
        printList(head);

        // Define the sublist boundaries
        int left = 2;
        int right = 4;
        System.out.println("Reversing from position " + left + " to " + right + "...");

        // Call the method
        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseBetween(head, left, right);

        // Print Reversed
        System.out.print("Reversed list: ");
        printList(reversedHead);
    }
}
