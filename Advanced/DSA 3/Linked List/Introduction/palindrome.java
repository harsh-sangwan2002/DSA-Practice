public class palindrome {

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int findSize(ListNode node) {

        ListNode temp = node;
        int count = 0;

        while (temp != null) {

            temp = temp.next;
            count++;
        }

        return count;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null, curr = head;

        while (curr != null) {

            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }

        return prev;
    }

    public int lPalin(ListNode A) {

        int size = findSize(A);
        ListNode t1 = A;
        ListNode temp = A;

        for (int i = 1; i < size / 2; i++)
            temp = temp.next;

        ListNode node = temp.next;
        temp.next = null;

        ListNode t2 = reverse(node);

        while (t1 != null && t2 != null) {

            if (t1.val != t2.val)
                return 0;

            t1 = t1.next;
            t2 = t2.next;
        }

        return 1;
    }
}
