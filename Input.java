package prj5;

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
 * Contains the overall functionality of this program
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 4.22.2021
 */
public class Input {

    /**
     * Initiates a new DataReader object to parse through
     * text files and then generates a new GUIWindow object
     * based on those files' data
     * 
     * @param args
     *            Array of strings representing the command
     *            line input arguments
     */
    public static void main(String[] args) {

        try {
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
                System.out.println(state.getName());
                state.sortByAlphabet();
                System.out.println(state.toString());
                System.out.println();
                state.sortByCaseFatalityRatio();
                System.out.println(state.toString());
                System.out.println("=====");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
