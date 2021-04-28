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

import cs2.Button;

/**
 * Creates and manages the GUI
 * 
 * @author Sean Stolburg, Emily Kroliczak, Zhengxiao Sun
 * @version 04.28.2021
 */
public class StateButton extends Button {
    
    private StateData state;
    
    /**
     * Constructs a StateButton
     * @param State the associated state
     */
    public StateButton(StateData State) {
        this.state = State;
    }
    
    /**
     * Gets the state
     * @return the state
     */
    public StateData getState() {
        return state;
    }
}
