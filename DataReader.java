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

    private LinkedList<StateData> stateData;

    /**
     * This constructor will creates a colony and window based on input files.
     * 
     * 
     */
    public DataReader(String filename)
        throws ParseException,
        FileNotFoundException {
        this.stateData = readFile(filename);
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
        String currentLine = scan.nextLine();
        LinkedList<StateData> state = new LinkedList<StateData>();

        while (scan.hasNextLine()) {
            LinkedList<Race> races = new LinkedList<Race>();
            currentLine = scan.nextLine();
            String[] array = scan.nextLine().split(", *");
            StateDate stateCase = new StateDate(array[0]);

            Race white = new Race("White", checkNA(array[1]), checkNA(
                array[6]));
            Race black = new Race("black", checkNA(array[2]), checkNA(
                array[7]));
            Race latinX = new Race("latinX", checkNA(array[3]), checkNA(
                array[8]));
            Race asian = new Race("asian", checkNA(array[4]), checkNA(
                array[9]));
            Race other = new Race("other", checkNA(array[5]), checkNA(
                array[10]));

            races.add(white);
            races.add(black);
            races.add(latinX);
            races.add(asian);
            races.add(other);

            stateCase.races.add(races);

            state.add(stateCase);
        }
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
            return -1;
        }
        return Integer.valueOf(string);
    }

}
