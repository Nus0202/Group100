package prj5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity
 * at all times.
 * I will not lie, cheat, or steal, nor will I accept the actions of
 * those who do.
 * --Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 */

/**
 * A Linked List of Nodes
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 4.22.2021
 * 
 * @param <T>
 *            the type of entry
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


    /**
     * Gets the number of entries in this LinkedList
     * 
     * @return This LinkedList's number of entries
     */
    @Override
    public int getSize() {
        return size;
    }


    /**
     * Adds the specified entry to the back of this LinkedList
     * 
     * @param entry
     *            The entry to be added
     */
    @Override
    public void add(T entry) {
        if (head == null) {
            head = new Node(entry);
            size = 1;
        }
        else {
            Node curr = head;
            for (int i = 0; i < size - 1; i++) {
                curr = curr.next;
            }
            curr.setNext(new Node(entry));

            size++;
        }
    }


    /**
     * If allowed, removes the specified entry within 
     * this LinkedList
     * 
     * @param entry
     *            The entry to be removed
     * 
     * @throws IllegalArgumentException
     *             Specified entry not found within LinkedList
     */
    @Override
    public void remove(T entry) {
        if (!contains(entry)) {
            throw new IllegalArgumentException();
        }
        else if (head.data.equals(entry)) {
            head = head.next;
            size--;
        }
        else {
            Node curr = head;
            for (int i = 0; i < size - 1; i++) {
                if (curr.next.data.equals(entry)) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
            size--;
        }
    }


    /**
     * Gets the data at the specified index
     * 
     * @param index
     *            The index
     * 
     * @return the data The data at the specified index
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        int counter = 0;
        T ret = null;
        for (T data : this) {
            if (counter == index) {
                ret = data;
            }
            counter++;
        }
        return ret;
    }


    /**
     * Determines whether this LinkedList contains the specified entry
     * 
     * @param entry
     *            The entry to be checked if it is within this LinkedList
     * 
     * @return True if this LinkedList contains the parameter entry
     *         and false if otherwise
     */
    private boolean contains(T entry) {
        for (T data : this) {
            if (data.equals(entry)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Sorts the LinkedList based on the ordering of the
     * parameter Comparator
     * 
     * @param comparator
     *            Determines the ordering of this LinkedList
     */
    public void sort(Comparator<T> comparator) {

        if (this.getSize() > 0) {

            Node unsorted = head.getNext();
            Node sorted = head;
            sorted.setNext(null);

            while (unsorted != null) {

                Node nodeToInsert = unsorted;
                unsorted = unsorted.getNext();
                insertComparator(nodeToInsert, comparator);
            }
        }
    }


    /**
     * Helper method that sorts the LinkedList based on the
     * parameter Comparator
     * 
     * @param node
     *            The node needed to be sorted
     * @param comparator
     *            Determines the ordering of the LinkedList
     */
    private void insertComparator(Node node, Comparator<T> comparator) {

        T currentData = node.getData();
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode != null && comparator.compare(currentData,
            currentNode.getData()) > 0) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode != null) {
            previousNode.setNext(node);
            node.setNext(currentNode);
        }
        else {
            node.setNext(currentNode);
            head = node;
        }
    }


    /**
     * Iterator method that creates Iterator object
     *
     * @return new Iterator object
     */
    @Override
    public Iterator<T> iterator() {
        return new LLIterator();
    }


    /**
     * Returns a string representation of this LinkedList
     * 
     * @return This LinkedList string representation
     */
    @Override
    public String toString() {
        String returning = "";

        Node current = head;
        while (current != null) {
            returning = returning + "" + current.data.toString();
            current = current.next;
            if (current != null) {
                returning = returning + "\n";
            }
        }
        return returning;
    }

    /**
     * A Node in the Linked List
     * 
     * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
     * @version 4.22.2021
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * Constructs a Node
         * 
         * @param data
         *            data of the Node
         */
        public Node(T data) {
            this.data = data;
            next = null;
        }


        /**
         * Gets the next node
         * 
         * @return the next node
         */
        public Node getNext() {
            return next;
        }


        /**
         * Sets the next node
         * 
         * @param next
         *            the next node
         */
        public void setNext(Node next) {
            this.next = next;
        }


        /**
         * Gets the node's data
         * 
         * @return the data
         */
        public T getData() {
            return data;
        }


        /**
         * Updates the Node to have new data
         * 
         * @param data
         *            the new data
         */
        public void setData(T data) {
            this.data = data;
        }
    }


    /**
     * Iterates over the data in the LinkedList
     * 
     * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
     * @version 4.22.2021
     */
    public class LLIterator implements Iterator<T> {

        private Node curr = head;

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         *         and false if otherwise
         */
        @Override
        public boolean hasNext() {
            return curr != null && curr.data != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value or null
         */
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
