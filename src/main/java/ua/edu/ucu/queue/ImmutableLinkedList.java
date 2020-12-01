package ua.edu.ucu.queue;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int len;

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    public ImmutableLinkedList(Node node) {
        this.head = node;
        this.tail = node;
        this.len = 1;
    }

    public ImmutableLinkedList add(Object e) {
        return add(len - 1, e);
    }

    public ImmutableLinkedList add(int index, Object e) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node addedNode = new Node(e);
        // create new Hew for new list
        Node newHead = new Node(this.head.getData());
        //create new list with this head
        ImmutableLinkedList newLst = new ImmutableLinkedList(newHead);

        Node thisCurrNode = this.head.getNext();
        Node newCurrNode = newLst.head;

        for (int i = 1; i < index; i++) {
            Node newNode = new Node(thisCurrNode.getData());
            newCurrNode.setNext(newNode);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            newLst.len += 1;
        }

        newCurrNode.setNext(addedNode); //add that node to new structure
//        added_node.setNext(thisCurrNode);//add next to added node
        newCurrNode = addedNode;
        newLst.len += 1;

        for (int i = index + 1; i < len; i++) {
            Node newNode = new Node(thisCurrNode.getData());
            newCurrNode.setNext(newNode);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            newLst.len += 1;
        }
        newLst.tail = newCurrNode;
        return newLst;
    }

    public ImmutableLinkedList addFirst(Object c) {
        return add(0, c);
    }


    public ImmutableList addAll(Object[] c) {
        return addAll(len - 1, c);
    }

    public ImmutableList addAll(int index, Object[] c) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableLinkedList newLst = new ImmutableLinkedList();
        for (int i = index; i < index + c.length; i++) {
            newLst = newLst.add(i, c[i - index]);
        }
        return newLst;
    }

    public Object get(int index) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node currNode = this.head;
        for (int i = 1; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }

    public Object getFirst() {
        return this.head.getData();
    }

    public Object getLast() {
        return this.tail.getData();
    }

    public ImmutableLinkedList remove(int index) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        // create new Hew for new list
        Node newHead = new Node(this.head.getData());
        //create new list with this head
        ImmutableLinkedList newLst = new ImmutableLinkedList(newHead);

        Node thisCurrNode = this.head.getNext();
        Node newCurrNode = newLst.head;

        for (int i = 1; i < index; i++) {
            Node newNode = new Node(thisCurrNode.getData());
            newCurrNode.setNext(newNode);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            newLst.len += 1;
        }
        for (int i = index + 1; i < len; i++) {
            Node newNode = new Node(thisCurrNode.getData());
            newCurrNode.setNext(newNode);

            newCurrNode = newCurrNode.getNext();
            thisCurrNode = thisCurrNode.getNext(); //copying previous nodes
            newLst.len += 1;
        }
        newLst.tail = newCurrNode;
        return newLst;
    }

    public ImmutableLinkedList set(int index, Object e) {
        if (index > len) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        ImmutableLinkedList delList = remove(index);
        ImmutableLinkedList newLst = delList.add(index, e);
        return newLst;
    }

    public int indexOf(Object e) {
        Node currNode = this.head;
        int index = 0;
        for (int i = 1; i < this.len; i++) {
            if (currNode.getData() == e) {
                return index;
            }
            index += 1;
            currNode = currNode.getNext();
        }
        return -1;
    }

    public int size() {
        return len;
    }

    public ImmutableLinkedList clear() {
        this.head = null;
        this.tail = null;
        this.len = 0;
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public Object[] toArray() {
        Object[] realList = new Object[this.len];
        Node currNode = this.head;

        for (int i = 1; i < this.len; i++) {
            realList[i] = currNode.getData();
            currNode = currNode.getNext();
        }
        return realList;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLen() {
        return this.len;
    }
}
