import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeLists {

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> list) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : list)
            pq.add(node);

        while (pq.size() != 0) {

            ListNode node = pq.remove();

            temp.next = node;
            temp = temp.next;

            if (node.next != null)
                pq.add(node.next);
        }

        return head.next;
    }
}
