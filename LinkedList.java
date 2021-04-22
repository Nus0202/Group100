package prj5;

import java.util.Iterator;
import java.lang.Iterable;

/**
 * A Linked List of Nodes
 * @author Sean Stolburg (seanstolburg88)
 * @version 4/22/2021
 * @param <T> the type of entry
 */
public class LinkedList<T> implements Iterable<T>, LinkedListInterface<T> {
    private Node head;
    private int size;
    
    /**
     * Constructs a LinkedList
     */
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(T entry) {
        if (head == null) {
            head = new Node(entry);
            size = 1;
        }
        else {
            T current = head.data;
            for (T data: this) {
                current = data;
            }
            getNode(current).setNext(new Node(entry));
            size++;
        }
    }
    
    private Node getNode(T data) {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr != null) {
                if (curr.data.equals(data)) {
                    return curr;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    @Override
    public void remove(T entry) {
        if (!contains(entry)) {
            return;
        }
        
        Node curr = head;
        for (int i = 0; i < size - 1; i++) {
            if (curr.next.data.equals(entry)) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        size--;
    }
    
    @Override
    public void setPosition(T entry, int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException();
        }
        else if (!contains(entry)) {
            throw new IllegalArgumentException();
        }
        
        //Remove old node
        remove(entry);
        size++;
        
        if (index == 0) {
            //add new node to head
            Node newHead = new Node(entry);
            newHead.setNext(head);
            head = newHead;
        }
        else {
            //add new node to index
            Node curr2 = head;
            for (int i = 0; i < size; i++) {
                if (i == index - 1) {
                    Node newNode = new Node(entry);
                    newNode.setNext(curr2.next);
                    curr2.setNext(newNode);
                }
                curr2 = curr2.next;
            }
        }
    }
    
    private boolean contains(T entry) {
        for (T data: this) {
            if (data.equals(entry)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new LLIterator();
    }
    
    @Override
    public String toString() {
        String returning = "{";

        Node current = head;
        while (current != null) {
            returning = returning + "" + current.data;
            current = current.next;
            if (current != null) {
                returning = returning + ", ";
            }
        }
        
        returning = returning + "}";
        return returning;
    }
    
    /**
     * A Node in the Linked List
     * @author Sean Stolburg (seanstolburg88)
     * @version 4/21/2021
     */
    private class Node {
        private T data;
        private Node next;
        
        /**
         * Constructs a Node
         * @param data data of the Node
         */
        public Node(T data) {
            this.data = data;
            next = null;
        }
        
        /**
         * Gets the next node
         * @return the next node
         */
        public Node getNext() {
            return next;
        }
        
        /**
         * Sets the next node
         * @param next the next node
         */
        public void setNext(Node next) {
            this.next = next;
        }
        
        /**
         * Gets the node's data
         * @return the data
         */
        public T getData() {
            return data;
        }
        
        /**
         * Updates the Node to have new data
         * @param data the new data
         */
        public void setData(T data) {
            this.data = data;
        }
    }
    
    /**
     * Iterates over the data in the LinkedList
     * @author Sean Stolburg (seanstolburg88)
     * @version 4/22/2021
     */
    private class LLIterator implements Iterator<T> {
        private Node curr = head;
        
        @Override
        public boolean hasNext() {
            return curr != null && curr.data != null;
        }

        @Override
        public T next() {
            if (curr == null) {
                return null;
            }
            T returning = curr.data;
            curr = curr.next;
            return returning;
        }
    }
}
