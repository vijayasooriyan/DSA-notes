public class SingleeLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    SingleeLinkedList() {
        head = null;
    }

    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPos(int pos, int val) {
        Node newNode = new Node(val);

        if (pos < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            insertAtBeginning(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void deleteAtPos(int pos) {
        if (head == null || pos < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        prev.next = temp.next;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SingleeLinkedList list = new SingleLinkedList();

        list.insertAtBeginning(1);
        list.display();
        System.out.println("");

        list.insertAtPos(1, 2);
        list.display();
        System.out.println("");

        list.insertAtPos(2, 3);
        list.display();
        System.out.println("");

        list.deleteAtPos(1);
        list.display();

        System.out.println("");
        list.insertAtEnd(10);
        list.display();
    }
}
