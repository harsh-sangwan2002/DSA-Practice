public class longest_palindrome {

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int count(ListNode h1, ListNode h2) {

        int count = 0;

        while (h1 != null && h2 != null) {

            if (h1.val != h2.val)
                break;
            ;

            count++;
            h1 = h1.next;
            h2 = h2.next;
        }

        return count;
    }

    public int solve(ListNode A) {

        if (A == null || A.next == null)
            return 1;

        ListNode prev = null, curr = A;
        int ans = 1;

        while (curr != null) {

            ListNode node = curr.next;
            curr.next = prev;

            // even size
            ans = Math.max(ans, 2 * count(curr, node));

            // odd size
            ans = Math.max(ans, 2 * count(prev, node) + 1);

            prev = curr;
            curr = node;
        }

        return ans;
    }
}
