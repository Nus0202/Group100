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
     * Tests setPosition(T entry, int index)
     */
    public void testSetPosition() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        Exception err = null;
        try {
            list.setPosition(1, 0);
        }
        catch (Exception e) {
            err = e;
        }
        assertNotNull(err);
        
        list.add(1);
        Exception err2 = null;
        try {
            list.setPosition(1, -1);
        }
        catch (Exception e) {
            err2 = e;
        }
        assertNotNull(err2);
        Exception err3 = null;
        try {
            list.setPosition(1, 10);
        }
        catch (Exception e) {
            err3 = e;
        }
        assertNotNull(err3);
        
        list.add(2);
        list.setPosition(2, 0);
        assertEquals("{2, 1}", list.toString());
        
        list.add(3);
        list.setPosition(3, 1);
        assertEquals("{2, 3, 1}", list.toString());
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
