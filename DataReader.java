// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Zhengxiao Sun, Emily Kroliczak, Sean Stolburg

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * The DataReader class will read the input and begin the GUIWindow.
 * 
 * @author Zhengxiao Sun
 *         PID:9062-79113
 * @version 2021.4.8
 */
public class DataReader {

    private LinkedList<StateData> data;

    /**
     * This constructor will creates a LinkedList of state data and window based
     * on input files.
     * 
     * @param filename
     *            the name of the input file.
     * 
     */
    public DataReader(String filename)
        throws ParseException,
        FileNotFoundException {
        this.data = readFile(filename);

        // will create a GUIWindow here.

    }


    /**
     * This method will reads the file.
     * 
     * @param filename
     * 
     * @return LinkedList<StateData>
     *         the LinkedList of state data from the input file
     */
    private LinkedList<StateData> readFile(String filename)
        throws ParseException,
        FileNotFoundException {

        Scanner scan = new Scanner(new File(filename));
        LinkedList<StateData> state = new LinkedList<StateData>();
        String currentLine = scan.nextLine();

        while (scan.hasNextLine()) {

            currentLine = scan.nextLine();
            String[] array = currentLine.split(", *");

            if (array.length < 11 || array.length > 11) {
                scan.close();
                throw new ParseException(
                    "The amount of data in this line is incorrect.");
            }

            StateData stateCase = new StateData(array[0], checkNA(array[1]),
                checkNA(array[2]), checkNA(array[3]), checkNA(array[4]),
                checkNA(array[5]), checkNA(array[6]), checkNA(array[7]),
                checkNA(array[8]), checkNA(array[9]), checkNA(array[10]));

            state.add(stateCase);
        }
        return state;
    }


    /**
     * This helper method will reads the planet file.
     * 
     * @param string
     *            we want to check with "NA"
     * 
     * @return int
     *         0 if is equals to "NA"
     * 
     */
    private int checkNA(String string) {
        if (string.equals("NA")) {
            return -1;
        }
        return Integer.valueOf(string);
    }


    /**
     * Getter method for the states field.
     * 
     * @return states field
     */
    public LinkedList<StateData> getStates() {
        return data;
    }

}
