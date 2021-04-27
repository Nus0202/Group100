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
    private Shape[] bars;
    private Button sortByAlphaButton;
    private Button sortByCFRButton;
    private Button quitButton;
    private StateButton[] stateButtons;
    private TextShape[] barTextShapes;

    private Window window;
    private LinkedList<StateData> stateData;
    private StateData currentState;

    
    /**
     * 
     */
    public GUIWindow(LinkedList<StateData> data) {
        this.stateData = data;
       
        this.window = new Window();

        this.currentState = this.stateData.getFront();

        this.sortByAlphaButton = new Button("SortByAlpha");
        sortByAlphaButton.onClick(this, "clickedSortByAlpha");
        this.window.addButton(sortByAlphaButton, WindowSide.NORTH);

        this.quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.NORTH);

        this.sortByCFRButton = new Button("SortByCFR");
        sortByCFRButton.onClick(this, "clickedSortByCFR");
        this.window.addButton(sortByCFRButton, WindowSide.NORTH);
        
         //this.stateButtons[0] = new StateButton(this.stateData.getFront());
        
    }


    /**
     * 
     */
    public void clickedSortByAlpha(Button button) {
        currentState.sortByAlphabet();
        updateShowedState(currentState);
    }


    /**
     * 
     */
    public void clickedSortByCFR(Button button) {
        currentState.sortByCaseFatalityRatio();
        updateShowedState(currentState);
    }


    /**
     * 
     */
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


    /**
     * 
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * 
     */
    private void updateShowedState(StateData state) {
        int index = 0;
        int barHeight = 0;
        for (Race race : state.getLinkedList()) {
            TextShape ts = barTextShapes[index];
            ts.setText(race.getRace());
            ts.moveTo((window.getGraphPanelWidth() - ts.getWidth()) / 2, window
                .getGraphPanelHeight() - (window.getGraphPanelHeight() - 20));
            window.addShape(ts);
            if (race.getCFR() >= 0) {
                barHeight = (int)(race.getCFR() / 10.0) * 100;
            }
            else {
                
            }
            index++;
        }

        // for each race in "state", update the associated bar and textShapes on
        // the window
        // so that they have the correct height/position/text/etc
    }
}
