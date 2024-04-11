//  Definition for singly-linked list.

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class sort_list {

    private ListNode findMid(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeLists(ListNode h1, ListNode h2) {

        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        ListNode head = null, tail = null;

        if (h1.val < h2.val) {
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

    public ListNode sortList(ListNode A) {

        if (A == null || A.next == null)
            return A;

        ListNode mid = findMid(A);
        ListNode h2 = mid.next;
        mid.next = null;

        ListNode h1 = sortList(A);
        h2 = sortList(h2);
        return mergeLists(h1, h2);
    }
}
