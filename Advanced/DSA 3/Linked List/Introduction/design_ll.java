public class design_ll {

    public static class Node {

        int data;
        Node next;

        Node() {

        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static int size = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (position >= 1 && position <= size + 1) {

            Node node = new Node(value);

            if (position == 1) {

                node.next = head;
                head = node;
            }

            else {

                Node temp = head;

                for (int i = 1; i < position - 1; i++)
                    temp = temp.next;

                node.next = temp.next;
                temp.next = node;
            }

            size++;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (position >= 1 && position <= size) {

            if (size == 1) {
                head = null;
                size--;
                return;
            }

            if (position == 1) {

                head = head.next;
                size--;
                return;
            }

            Node temp = head;

            for (int i = 1; i < position - 1; i++)
                temp = temp.next;

            temp.next = temp.next.next;
            size--;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp = head;

        while (temp != null) {

            if (temp.next == null)
                System.out.print(temp.data);

            else
                System.out.print(temp.data + " ");

            temp = temp.next;
        }
    }

}