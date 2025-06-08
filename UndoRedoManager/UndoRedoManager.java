package UndoRedoManager;

public class UndoRedoManager<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private DoubleNode<T> current;
    private int size;

    public UndoRedoManager() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public void addState(T state) {
        DoubleNode<T> newNode = new DoubleNode<>(state);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
;        } else {
            // Clear all redo states
            if(current != tail) {
                DoubleNode<T> temp = current.next;
                while(temp != null) {
                    DoubleNode<T> next = temp.next;
                    temp.previous = null;
                    temp.next = null;
                    temp = next;
                    size--;
                }
                current.next = null;
                tail = current;
            }

            //Append new state
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            current = newNode;
        }

        size++;
    }

    public void undo(){
        if(current != null && current.previous != null) {
            current = current.previous;
        } else {
            System.out.println("Cannot undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Cannot redo");
        }
    }

    public T getCurrentState() {
        if(current != null) {
            return current.value;
        } else {
            return null;
        }
    }

    // Debug Method
    public void traverse() {
        DoubleNode<T> temp = head;
        while(temp != null){
            if(temp == current) {
                System.out.print("[" + temp.value + "]");
            } else {
                System.out.print(temp.value);
            }
            if (temp.next != null) {
                System.out.print("<->");
            }

            temp = temp.next;
        }
        System.out.println();
    }
}
