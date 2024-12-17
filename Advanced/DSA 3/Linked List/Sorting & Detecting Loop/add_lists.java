//  Definition for singly-linked list.

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class add_lists {

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        if (A == null)
            return B;
        if (B == null)
            return A;

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;

        while (A != null || B != null || carry != 0) {

            int d1 = A == null ? 0 : A.val;
            int d2 = B == null ? 0 : B.val;
            int sum = d1 + d2 + carry;
            int val = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(val);
            dummy.next = node;
            dummy = dummy.next;

            if (A != null)
                A = A.next;
            if (B != null)
                B = B.next;
        }

        return head.next;
    }
}
