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

    @SuppressWarnings("unused")
    private LinkedList<StateData> data;

    /**
     * This constructor will creates a colony and window based on input files.
     * 
     * 
     */
    public DataReader(String filename)
        throws ParseException,
        FileNotFoundException {
        this.data = readFile(filename);

        // will create a GUIWindow here.

    }


    /**
     * This method will reads the planet file.
     * 
     * @param filename
     * 
     * 
     * 
     */
    private LinkedList<StateData> readFile(String filename)
        throws ParseException,
        FileNotFoundException {

        Scanner scan = new Scanner(new File(filename));
        LinkedList<StateData> state = new LinkedList<StateData>();

        while (scan.hasNextLine()) {

            String[] array = scan.nextLine().split(", *");

            StateData stateCase = new StateData(array[0], checkNA(array[1]),
                checkNA(array[2]), checkNA(array[3]), checkNA(array[4]),
                checkNA(array[5]), checkNA(array[6]), checkNA(array[7]),
                checkNA(array[8]), checkNA(array[9]), checkNA(array[10]));

            state.add(stateCase);
        }
        return state;
    }


    /**
     * This method will reads the planet file.
     * 
     * @param string
     * 
     * 
     * 
     */
    private int checkNA(String string) {
        if (string.equals("NA")) {
            return 0;
        }
        return Integer.valueOf(string);
    }

}
