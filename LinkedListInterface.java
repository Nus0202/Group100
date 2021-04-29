package prj5;

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
 * Interface for a Linked List
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 4.22.2021
 * 
 * @param <T>
 *            The type parameter to be used for LinkedList
 */
public interface LinkedListInterface<T> {

    /**
     * Gets the number of entries
     * 
     * @return number of entries
     */
    public abstract int getSize();


    /**
     * Adds the specified entry
     * 
     * @param entry
     *            the entry to add
     */
    public abstract void add(T entry);


    /**
     * Removes the specified entry
     * 
     * @param entry
     *            the entry to remove
     */
    public abstract void remove(T entry);


    /**
     * Gets the data at the specified index
     * 
     * @param index
     *            The index
     *            
     * @return the data The data at the specified index
     */
    public abstract T get(int index);
}
