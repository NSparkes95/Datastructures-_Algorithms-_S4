public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedlist(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createSingleLinkedlist(nodeValue);
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void delete(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        if (position == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (position == size - 1) {
                tail = current;
            }
        }
        size--;
    }

    public static class Node {
        public int value;
        public Node next;
    }
}

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // Insertion tests
        list.createSingleLinkedlist(10);      // List: 10
        list.insertLinkedList(20, 1);         // List: 10 -> 20
        list.insertLinkedList(30, 2);         // List: 10 -> 20 -> 30
        list.insertLinkedList(5, 0);          // List: 5 -> 10 -> 20 -> 30
        list.insertLinkedList(25, 2);         // List: 5 -> 10 -> 25 -> 20 -> 30

        System.out.println("List after insertions:");
        printList(list);

        // Deletion tests
        list.delete(0);                       // Delete head → List: 10 -> 25 -> 20 -> 30
        list.delete(2);                       // Delete from middle → List: 10 -> 25 -> 30
        list.delete(list.size - 1);           // Delete tail → List: 10 -> 25

        System.out.println("List after deletions:");
        printList(list);
    }

    public static void printList(SingleLinkedList list) {
        SingleLinkedList.Node current = list.head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
