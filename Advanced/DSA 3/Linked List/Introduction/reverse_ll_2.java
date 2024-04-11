public class reverse_ll_2 {

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head;

        while (curr != null) {

            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {

        if (A == null || A.next == null || B >= C)
            return A;

        ListNode curr = A, from = null, to = null, first = null, last = null, head = A;
        int count = 0;

        while (curr != null) {

            count += 1;

            if (count < B)
                first = curr;

            else if (count == B)
                from = curr;

            else if (count == C) {

                to = curr;
                last = to.next;
                to.next = null;
                break;
            }

            curr = curr.next;
        }

        reverse(from);

        if (first != null)
            first.next = to;

        else
            head = to;

        from.next = last;

        return head;
    }
}
