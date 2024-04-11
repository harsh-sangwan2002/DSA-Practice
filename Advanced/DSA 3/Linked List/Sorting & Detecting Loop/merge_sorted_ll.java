//  Definition for singly-linked list.

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class merge_sorted_ll {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        if (A == null)
            return B;
        if (B == null)
            return A;

        ListNode head = null, tail = null, h1 = A, h2 = B;

        if (A.val < B.val) {
            head = h1;
            tail = h1;
            h1 = h1.next;
        }

        else {
            head = h2;
            tail = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {

            if (h1.val < h2.val) {
                tail.next = h1;
                h1 = h1.next;
            }

            else {
                tail.next = h2;
                h2 = h2.next;
            }

            tail = tail.next;
        }

        if (h1 == null)
            tail.next = h2;

        else
            tail.next = h1;

        return head;
    }
}
