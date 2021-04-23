package prj5;

import java.util.Iterator;

import prj5.LinkedList.LLIterator;

/**
 * Tests LinkedList
 * @author Sean Stolburg (seanstolburg88)
 * @version 4/22/2021
 */
public class LinkedListTest extends student.TestCase {
    /**
     * Tests getSize()
     */
    public void testGetSize() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        assertEquals(0, list.getSize());
        list.add(1);
        assertEquals(1, list.getSize());
        list.remove(1);
        assertEquals(0, list.getSize());
    }
    
    /**
     * Tests add(T entry)
     */
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        assertEquals(1, list.getSize());
        list.add(3);
        assertEquals(2, list.getSize());
    }
    
    /**
     * Tests remove(T entry)
     */
    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        Exception err = null;
        try {
            list.remove(2);
        }
        catch (Exception e) {
            err = e;
        }
        assertNotNull(err);
        
        list.remove(1);
        assertEquals("{}", list.toString());
        
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.remove(3);
        assertEquals("{1, 2}", list2.toString());
    }
    
    /**
     * Tests iterator()
     */
    public void testIterator() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Iterator<Integer> it = list.iterator();
        assertNotNull(it);
    }
    
    /**
     * Tests toString()
     */
    public void testToString() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertEquals("{}", list.toString());
        list.add(1);
        list.add(2);
        assertEquals("{1, 2}", list.toString());
        list.remove(1);
        assertEquals("{2}", list.toString());
    }
}
