public class partition_list {

    // Definition for singly-linked list.

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode A, int B) {

        ListNode head = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode temp = A, tail = head2, res = head;

        while (temp != null) {

            if (temp.val < B) {

                ListNode node = new ListNode(temp.val);
                head.next = node;
                head = head.next;
            }

            else {

                ListNode node = new ListNode(temp.val);
                head2.next = node;
                head2 = head2.next;
            }

            temp = temp.next;
        }

        head.next = tail.next;
        return res.next;
    }
}
