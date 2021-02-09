package Exercises2_2;

public class List<T> {
    private Node<T> header;
    private int size;

    public List() {
        header = new Node<T>();
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value, header.getPrev(), header);
        header.getPrev().setNext(newNode);
        header.setPrev(newNode);
        size++;
    }

    private Node<T> search(int position) {
        int currPosition = 1;
        Node<T> currNode = header.getNext();
        while(currPosition != position) {
            currNode = currNode.getNext();
            currPosition++;
        }

        return currNode;
    }

    public void add(T value, int position) throws OutOfListSizeException {
        if(position < 0) {
            throw new OutOfListSizeException("The insertion position cannot be negative.");
        }

        if(position > size) {
            add(value);
        } else {
            Node<T> currNode = search(position);
            Node<T> newNode = new Node<T>(value, currNode.getPrev(), currNode);
            currNode.getPrev().setNext(newNode);
            currNode.setPrev(newNode);
            size++;
        }
    }

    public Node<T> get(int position) throws OutOfListSizeException {
        if((position > size) || (position < 0)) {
            throw new OutOfListSizeException("Position " + position + " out of list. List size: " + size + ".");
        }

        return search(position);
    }

    public void remove(int position) throws OutOfListSizeException {
        if((position > size) || (position < 0)) {
            throw new OutOfListSizeException("Position " + position + " out of list. List size: " + size + ".");
        }

        Node<T> currNode = search(position);
        currNode.getNext().setPrev(currNode.getPrev());
        currNode.getPrev().setNext(currNode.getNext());
    }

    @Override
    public String toString() {
        String listString = "List:\theader";

        Node<T> curr = header.getNext();
        while(!curr.equals(header)) {
            listString += " -> ";
            listString += curr.getValue();
            curr = curr.getNext();
        }

        return listString + " [-> header]";
    }
}
