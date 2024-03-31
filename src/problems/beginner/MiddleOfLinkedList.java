package problems.beginner;

public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        // Time complexity: O(n)
        // Space complexity: O(1)
        ListNode middle = head;
        ListNode current = head;
        while (current != null && current.next != null) {
            middle = middle.next;
            current = current.next.next;
        }
        return middle;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(middleNode(head).val);  // Output: 3
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
