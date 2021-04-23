// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Zhengxiao Sun, Emily Kroliczak, Sean Stolburg

package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * This is a test class for DataReader class.
 * 
 * @author Zhengxiao Sun
 *         PID:9062-79113
 * @version 2021.4.8
 */
public class DataReaderTest extends student.TestCase {

    private String filename;
    private DataReader read;

    /**
     * sets up any needed variables for test methods
     * 
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void setUp() {
        filename = "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv";
    }


    public void testDataReader() {
        String filename1 = "CovidOutput_1.txt";
        Exception thrown = null;
        try {
            read = new DataReader(filename);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof ParseException);

    }
}
 
