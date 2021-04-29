package prj5;

import cs2.Button;

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
 * Represents the state buttons along the bottom of
 * the GUIWindow object
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 04.27.2021
 */
public class StateButton extends Button {

    private StateData state;

    /**
     * Creates a new StateButton
     * 
     * @param State
     *            The StateData object whose data will 
     *            correspond to this StateButton
     */
    public StateButton(StateData State) {
        this.state = State;
    }

    /**
     * Gets the StateData object of this StateButton
     * 
     * @return This StateButton's StateData object
     */
    public StateData getState() {
        return state;
    }

}
