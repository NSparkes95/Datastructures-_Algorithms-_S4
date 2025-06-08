package UndoRedoManager;

public class DoubleNode<T> {
    public T value;
    public DoubleNode<T> previous;
    public DoubleNode<T> next;

    public DoubleNode(T value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}
