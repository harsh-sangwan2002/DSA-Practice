public class k_reverse {

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode reverse(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode prev = null, curr = node;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseList(ListNode A, int B) {

        if (A == null || A.next == null || B == 1)
            return A;

        ListNode head = A, curr = A;

        for (int i = 1; i < B; i++)
            curr = curr.next;

        ListNode next = curr.next;
        ListNode h2 = reverseList(next, B);

        curr.next = null;
        ListNode h1 = reverse(A);

        head.next = h2;
        return h1;
    }
}
