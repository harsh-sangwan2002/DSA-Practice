import java.util.HashMap;

public class copy_list {

    // Definition for singly-linked list with a random pointer.
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        RandomListNode t1 = head.next, t2 = node;

        while (t1 != null) {

            RandomListNode temp = new RandomListNode(t1.label);
            map.put(t1, temp);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }

        t1 = head;
        t2 = node;
        while (t1 != null) {

            RandomListNode temp = t1.random;
            t2.random = map.get(temp);
            t1 = t1.next;
            t2 = t2.next;
        }

        return map.get(head);
    }
}
