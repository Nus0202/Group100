package prj5;

/**
 * Interface for a Linked List
 * @author Sean Stolburg (seanstolburg88)
 * @version 4/21/2021
 */
public interface LinkedListInterface<T> {
    /**
     * Gets the number of entries
     * @return number of entries
     */
    public abstract int getSize();
    
    /**
     * Adds an entry
     * @param entry the entry to add
     */
    public abstract void add(T entry);
    
    /**
     * Removes an entry
     * @param entry the entry to remove
     */
    public abstract void remove(T entry);
    
    /**
     * Changes the position of the given entry
     * @param entry the entry
     * @param index to this position
     */
    public abstract void setPosition(T entry, int index);
}
