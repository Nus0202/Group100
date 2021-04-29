package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

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
 * The DataReader class will read the input and begin the GUIWindow
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 04.21.2021
 */
public class DataReader {

    private LinkedList<StateData> data;

    /**
     * Creates a LinkedList of StateData objects and generates
     * a new GUIWindow object based on the input files
     * 
     * @param filename
     *            The name of the input file
     */
    public DataReader(String filename)
        throws ParseException,
        FileNotFoundException {
        this.data = readFile(filename);

        new GUIWindow(this.data);
    }


    /**
     * Parses through the parameter String object and if valid,
     * generates a LinkedList of StateData objects based on the
     * String object's data
     * 
     * @param filename
     *            The text file to be parsed through
     * 
     * @return LinkedList<StateData>
     *         The LinkedList of StateData objects from
     *         the input file
     * 
     * @throws FileNotFoundException
     *             If the file does not exist
     * 
     * @throws ParseException
     *             If the file's data format is incorrect
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

            if (array.length != 11) {
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
     * This helper method will read the file and if the parameter
     * string contains "NA", it will return -1.
     * 
     * @param string
     *            The string this method checks for "NA"
     * 
     * @return -1 if is equals to "NA" or else
     *         the string's parse Integer value
     */
    private int checkNA(String string) {
        if (string.equals("NA")) {
            return -1;
        }
        return Integer.valueOf(string);
    }


    /**
     * Gets the LinkedList of StateData objects
     * 
     * @return The LinkedList of StateData objects
     */
    public LinkedList<StateData> getStates() {
        return data;
    }
}
