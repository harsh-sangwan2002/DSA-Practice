public class remove_from_end {

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {

        if (A == null || A.next == null)
            return null;

        ListNode fast = A;

        for (int i = 1; i <= B && fast != null; i++)
            fast = fast.next;

        if (fast == null)
            return A.next;

        ListNode slow = A;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return A;
    }
}
