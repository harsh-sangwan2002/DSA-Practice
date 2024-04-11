public class reorder_list {

    // Definition for singly-linked list.

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode findMid(ListNode node) {

        if (node == null || node.next == null)
            return node;

        ListNode slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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

    public ListNode reorderList(ListNode A) {

        if (A == null || A.next == null)
            return A;

        ListNode h1 = A;

        ListNode mid = findMid(A);
        ListNode h2 = mid.next;
        mid.next = null;
        h2 = reverse(h2);

        boolean flag = true;

        while (h1 != null && h2 != null) {

            if (flag) {
                ListNode temp = h1.next;
                h1.next = h2;
                h1 = temp;
                flag = false;
            }

            else {
                ListNode temp = h2.next;
                h2.next = h1;
                h2 = temp;
                flag = true;
            }
        }

        return A;
    }
}
