package ua.edu.ucu.queue;

public class Node<E> {
    private E data;
    private Node next;
    public Node(E data) {
        this.data = data;
    }

    void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public E getData() {
        return this.data;
    }
}
