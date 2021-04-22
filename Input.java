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
     * main method which will uses different constructor by different
     * parameters.
     * 
     * @param args
     *            Array of strings representing the command
     *            line input arguments
     */
    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException {
        if (args.length == 1) {
            new DataReader(args[0]);
        }
        else {
            new DataReader("input.txt");
        }
    }
}
