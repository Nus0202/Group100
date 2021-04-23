// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Zhengxiao Sun, Emily Kroliczak, Sean Stolburg

package prj5;

/**
 * 
 * 
 * @author Zhengxiao Sun
 *         PID:9062-79113
 * @version 2021.4.22
 */

import java.io.FileNotFoundException;
import bsh.ParseException;

public class Input {

    /**
     * main method which will uses constructor by
     * parameters.
     * 
     * @param args
     *            Array of strings representing the command
     *            line input arguments
     */
    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException {

        DataReader reader;

        if (args.length == 1) {
            reader = new DataReader(args[0]);
        }
        else {
            reader = new DataReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

        LinkedList<StateData> states = reader.getStates();
        
        for (StateData state : states) {
            System.out.println(state.toString());
            System.out.println("----------------------------------------");
        }
         
    }
}
