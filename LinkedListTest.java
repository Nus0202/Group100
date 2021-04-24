package prj5;

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
 * Tests all of the methods in the LinkedList class to
 * ensure that they run and perform as expected
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 4.22.2021
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
        assertEquals("", list.toString());

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.remove(3);
        assertEquals("1\n" + "2", list2.toString());
    }


    /**
     * Tests sort() when the LinkedList is empty
     */
    public void testSortEmpty() {

        LinkedList<Race> emptyList = new LinkedList<Race>();

        emptyList.sort(new SortByCFR());

        assertEquals("", emptyList.toString());

    }


    /**
     * Tests sort() when the LinkedList is not empty
     */
    public void testSortOneEntry() {

        LinkedList<Race> list = new LinkedList<Race>();

        list.add(new Race("white", 5000, 2000));

        list.sort(new SortByAlpha());

        assertEquals("white: 5000 cases, 40% CFR", list.toString());
    }


    /**
     * Tests sort() when the LinkedList is not empty
     */
    public void testSortMultEntries() {

        LinkedList<Race> list = new LinkedList<Race>();

        list.add(new Race("white", 5000, 2000));
        list.add(new Race("black", 5000, 3000));
        list.add(new Race("asian", 5000, 4000));

        list.sort(new SortByAlpha());

        assertEquals("asian: 5000 cases, 80% CFR\n"
            + "black: 5000 cases, 60% CFR\n" + "white: 5000 cases, 40% CFR",
            list.toString());

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
        assertEquals("", list.toString());
        list.add(1);
        list.add(2);
        assertEquals("1\n" + "2", list.toString());
        list.remove(1);
        assertEquals("2", list.toString());
    }
}

