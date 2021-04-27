
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
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;

/**
 * Specifies the bar's possible positions
 * (i.e., left, middle, or right)
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 4.27.2021
 */
public class GUIWindow {
    private Shape leftBar;
    private Shape midLeftBar;
    private Shape midBar;
    private Shape midRightBar;
    private Shape rightBar;
    
    private Button sortByAlphaButton;
    private Button sortByCFRButton;
    private Button quitButton;
    private StateButton[] stateButtons;
    private TextShape[] barTextShapes;
    
    private Window window;
    private LinkedList<StateData> stateData;
    private StateData currentState;
    
    public GUIWindow(LinkedList<StateData> data) {
        this.stateData = data;
        
        //more here
    }
    
    public void clickedSortByAlpha(Button button) {
        currentState.sortByAlphabet();
        updateShowedState(currentState);
    }
    
    public void clickedSortByCFR(Button button) {
        currentState.sortByCaseFatalityRatio();
        updateShowedState(currentState);
    }
    
    public void clickedState(Button button) {
        if (button.getClass() == StateButton.class) {
            StateButton cast = (StateButton) button;
            currentState = cast.getState();
            updateShowedState(cast.getState());
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    
    public void clickedQuit(Button button) {
        
    }
    
    private void updateShowedState(StateData state) {
        //shows the "state" based on it's race's order
    }
}
