package Exercises2_2;

public class Node<T> {
    private T value;
    private Node<T> prev;
    private Node<T> next;

    public T getValue() { return value; }
    public Node<T> getPrev() { return prev; }
    public Node<T> getNext() { return next; }

    public void setValue(T value) { this.value = value; }
    public void setPrev(Node<T> prev) { this.prev = prev; }
    public void setNext(Node<T> next) { this.next = next; }

    public Node() {
        value = null;
        prev = this;
        next = this;
    }

    public Node(T value, Node<T> prev, Node<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
