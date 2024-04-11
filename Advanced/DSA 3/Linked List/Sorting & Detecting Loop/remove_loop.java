public class remove_loop {

    // Definition for singly-linked list.

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A) {

        ListNode slow = A, fast = A;
        boolean flag = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return A;

        slow = A;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = fast;

        while (temp.next != fast) {
            temp = temp.next;
        }

        temp.next = null;
        return A;
    }
}
