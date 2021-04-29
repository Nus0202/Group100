package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

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
 * Contains the functionality of this program's graphical user
 * interface, consisting of one window and several buttons, and create the
 * Shape objects that are displayed on this program's window
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 04.27.2021
 */
public class GUIWindow {

    private static final int barWidth = 20;
    private static final int barLabelGap = 20;
    private Shape[] bars;

    private Button sortByAlphaButton;
    private Button sortByCFRButton;
    private Button quitButton;
    private StateButton[] stateButtons;
    private Window window;
    private LinkedList<StateData> stateData;
    private StateData currentState;

    /**
     * Creates a new GUIWindow object
     * 
     * @param data
     *            The data to be displayed
     */
    public GUIWindow(LinkedList<StateData> data) {

        this.stateData = data;

        this.window = new Window();

        this.stateButtons = new StateButton[6];
        this.bars = new Shape[5];

        this.currentState = this.stateData.get(0);
        this.currentState.sortByCaseFatalityRatio();

        this.sortByAlphaButton = new Button("SortByAlpha");
        sortByAlphaButton.onClick(this, "clickedSortByAlpha");
        this.window.addButton(sortByAlphaButton, WindowSide.NORTH);

        this.quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.NORTH);

        this.sortByCFRButton = new Button("SortByCFR");
        sortByCFRButton.onClick(this, "clickedSortByCFR");
        this.window.addButton(sortByCFRButton, WindowSide.NORTH);

        this.addStateButtons();
        this.updateShowedState(currentState);
    }


    /**
     * Internal method that creates the buttons representing
     * each state and adds them to this GUIwindow
     */
    private void addStateButtons() {

        String[] stateAbbrev = { "DC", "GA", "MD", "NC", "TN", "VA" };

        for (int x = 0; x < 6; x++) {

            this.stateButtons[x] = new StateButton(this.stateData.get(x));
            this.stateButtons[x].setTitle("Represent " + stateAbbrev[x]);
            this.stateButtons[x].onClick(this, "clickedState");
            this.window.addButton(this.stateButtons[x], WindowSide.SOUTH);
        }
    }


    /**
     * Internal method that calculates the height of the bar
     * based on the parameter's CFR value
     * 
     * @param race
     *            The Race object whose bar height this
     *            method will calculate
     */
    private int calBarHeight(Race race) {

        return (int)((race.getCFR() / 10.0) * 100);

    }


    /**
     * Internal method that identifies the max bar height out of
     * all the input data
     */
    private int getMaxBarHeight() {

        int max = 0;

        for (StateData state : this.stateData) {

            for (Race race : state.getLinkedList()) {

                int barHeight = calBarHeight(race);

                if (barHeight > max) {
                    max = barHeight;
                }
            }
        }
        return max;
    }


    /**
     * Internal method that creates the shapes/bars and adds
     * them to this GUIwindow
     */
    private void buildShapes() {

        int maxBarHeight = getMaxBarHeight();
        int yValue = (window.getGraphPanelHeight() - 150);

        for (int x = 0; x < 5; x++) {

            int barHeight = calBarHeight(this.currentState.getLinkedList().get(
                x));
            bars[x] = new Shape((((x + 1) * this.window.getGraphPanelWidth())
                / 6), yValue + maxBarHeight - barHeight, barWidth, barHeight,
                Color.BLUE);
            this.window.addShape(bars[x]);
        }
    }


    /**
     * Internal method that creates the textShapes representing
     * the Race and CFR labels and adds them to this GUIwindow
     */
    private void buildLabels(Shape bar, Race race) {

        TextShape raceLabel = new TextShape(bar.getX(), bar.getY() + bar
            .getHeight() + barLabelGap, race.getRace());

        raceLabel.moveTo(bar.getX() + barWidth / 2 - raceLabel.getWidth() / 2,
            raceLabel.getY());

        TextShape CFRLabel = null;
        if (race.getCFR() == -1) {
            CFRLabel = new TextShape(bar.getX(), bar.getY() + bar.getHeight(),
                "NA");
        }
        else {

            String cfr = String.valueOf(race.getCFR());
            String checkRemainder = cfr.substring(cfr.length() - 1, cfr
                .length());

            int num = Integer.parseInt(checkRemainder);

            if (num != 0) {
                CFRLabel = new TextShape(bar.getX(), raceLabel.getY()
                    + barLabelGap, race.getCFR() + "%");
            }
            else {
                String intString = cfr.substring(0, cfr.length() - 2);
                CFRLabel = new TextShape(bar.getX(), raceLabel.getY()
                    + barLabelGap, intString + "%");
            }
        }
        CFRLabel.setX(bar.getX() + barWidth / 2 - CFRLabel.getWidth() / 2);

        this.window.addShape(raceLabel);
        this.window.addShape(CFRLabel);
    }


    /**
     * Called when the associated button is clicked
     * 
     * @param button
     *            The "SortByAlpha" button on this GUIwindow
     */
    public void clickedSortByAlpha(Button button) {

        for (StateData state : stateData) {
            state.sortByAlphabet();
        }
        updateShowedState(currentState);
    }


    /**
     * Called when the associated button is clicked
     * 
     * @param button
     *            The "SortByCFR" button on this GUIwindow
     */
    public void clickedSortByCFR(Button button) {

        for (StateData state : stateData) {
            state.sortByCaseFatalityRatio();
        }
        updateShowedState(currentState);
    }


    /**
     * Implements the state buttons by displaying that button's
     * state data once the user clicks on it
     * 
     * @param button
     *            The button of the wanted state
     */
    public void clickedState(Button button) {

        if (button.getClass() == StateButton.class) {
            StateButton cast = (StateButton)button;
            currentState = cast.getState();
            updateShowedState(cast.getState());
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Implements the "Quit" button by closing the window once the
     * user clicks on it
     * 
     * @param button
     *            The "Quit" button on this GUIwindow
     */
    public void clickedQuit(Button button) {

        System.exit(0);

    }


    /**
     * Internal method that generates/updates and adds all
     * the shapes and labels to this GUIWindow
     * 
     * @param state
     *            The stateData object whose data will be updated/shown
     */
    private void updateShowedState(StateData state) {

        this.window.removeAllShapes();

        TextShape title = new TextShape(window.getWidth() / 2, 20, currentState
            .getName() + " Case Fatality Ratio by Race");
        title.setX((window.getWidth() / 2) - (title.getWidth() / 2));

        this.window.addShape(title);

        this.buildShapes();

        for (int x = 0; x < 5; x++) {
            this.buildLabels(bars[x], state.getLinkedList().get(x));
        }
    }
}
