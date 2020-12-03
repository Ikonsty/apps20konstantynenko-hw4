package ua.edu.ucu.queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue <E> implements Iterable <E> {
    private ImmutableLinkedList content;

    public Queue() {
        content = new ImmutableLinkedList();
    }

    public Iterator<E> iterator() {
        return new QuIterator<E>();
    }

    private final class QuIterator <E>  implements Iterator <E> {
        private Node curr;
        QuIterator() {
            this.curr = content.getTail();
        }

        public boolean hasNext() {
            return (this.curr != null);
        }

        public E next() {
            if (this.curr == null) {
                throw new NullPointerException();
            }
            this.curr = this.curr.getNext();
            E e = (E) this.curr.getData();
            if (this.curr == content.getTail()) {
                this.curr = null;
            }
            return e;
        }

        public void forEach(Consumer<? super E> consumer) {

        }

        public Spliterator<E> spliterator() {
            return null;
        }
    }

    public Object peek() {
        if (content.getHead() == null){
            throw new ArrayIndexOutOfBoundsException("No peek is here");
        }
        return content.getHead();
    }

    public Object dequeue() {
        if (content.getHead() == null){
            throw new ArrayIndexOutOfBoundsException("No elements are here");
        }
        Object value = content.getHead();
        content.setHead(content.getHead().getNext());
        return value;
    }

    public void enqueue(Object e) {
        Node<Object> newNode = new Node<>(e);
        content.add(newNode);
    }
}