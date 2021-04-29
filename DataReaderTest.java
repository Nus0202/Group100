package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Tests all of the methods in the DataReader class to
 * ensure that they run and perform as expected
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 04.21.2021
 */
public class DataReaderTest extends student.TestCase {

    private String filename;
    private DataReader read;

    /**
     * Sets up any needed variables for test methods
     * 
     */
    public void setUp() {
        filename = "Cases_and_Deaths_by_race_RANDOM_NUMBERSERROR.csv";
    }


    /**
     * Test DataReader() method (constructor) when first file 
     * has an incorrect data format and the second file does
     * not exist 
     * 
     */
    public void testDataReader() {
        Exception thrown = null;
        try {
            read = new DataReader(filename);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof ParseException);

        String emptyFilename = "emptyfile";
        Exception thrown1 = null;
        try {
            read = new DataReader(emptyFilename);
        }
        catch (Exception exception) {
            thrown1 = exception;
        }
        assertTrue(thrown1 instanceof FileNotFoundException);
    }


    /**
     * Test getStates() 
     * 
     */
    public void testGetStates() {
        String filename2 = "Cases_and_Deaths_by_race_CRDT_Sep2020.csv";
        Exception thrown = null;
        try {
            read = new DataReader(filename2);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertFalse(thrown instanceof ParseException);

        DataReader read2 = read;
        assertEquals(read.getStates(), read2.getStates());
    }
}
