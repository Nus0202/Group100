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
 * Creates and manages the GUI
 * 
 * @author Emily Kroliczak, Sean Stolburg, Zhengxiao Sun
 * @version 04.28.2021
 */
public class GUIWindow {
    private Shape leftBar;
    private Shape midLeftBar;
    private Shape midBar;
    private Shape midRightBar;
    private Shape rightBar;
    static final int barWidth = 20;
    static final int barLabelGap = 20;

    private Button sortByAlphaButton;
    private Button sortByCFRButton;
    private Button quitButton;
    private StateButton[] stateButtons;

    private Window window;
    private LinkedList<StateData> stateData;
    private StateData currentState;
    
    /**
     * Constructs a GUIWindow
     * @param data data from the DataReader
     */
    public GUIWindow(LinkedList<StateData> data) {

        this.stateData = data;

        this.window = new Window();

        this.stateButtons = new StateButton[6];

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
     * Creates the stateButtons and adds them to this GUIWindow
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
     * Generates the height of the bar
     */
    private int calBarHeight(Race race) {

        return (int)((race.getCFR() / 10.0) * 100);

    }


    /**
     * Returns the max Bar Height
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
     * Creates the shapes/bars and adds them to this GUIWindow
     */
    private void buildShapes() {

        int maxBarHeight = getMaxBarHeight();
        int yValue = (window.getGraphPanelHeight() - 150);

        for (int x = 0; x < 5; x++) {

            int barHeight = calBarHeight(this.currentState.getLinkedList().get(
                x));
            bars[x] = new Shape((((x + 1) * this.window.getGraphPanelWidth()) / 6),
                yValue + maxBarHeight - barHeight, barWidth, barHeight,
                Color.BLUE);
            this.window.addShape(bars[x]);
        }       
    }
    /**
     * Creates the textShapes for this GUIWindow
     * @param bar based on this bar
     * @param race based on this race
     */
    private void buildLabels(Shape bar, Race race) {

        TextShape raceLabel = new TextShape(bar.getX(), bar.getY() + bar
            .getHeight() + barLabelGap, race.getRace());

        raceLabel.moveTo(bar.getX() + barWidth / 2 - raceLabel.getWidth() / 2,
            raceLabel.getY());

        TextShape CFRLabel = null;
        if (race.getCFR() == -1) {
            CFRLabel = new TextShape(bar.getX(), raceLabel.getY() + barLabelGap,
                "NA");
        }
        else {
            CFRLabel = new TextShape(bar.getX(), raceLabel.getY() + barLabelGap,
                race.getCFR() + "%");
        }

        CFRLabel.moveTo(bar.getX() + barWidth / 2 - CFRLabel.getWidth() / 2,
            CFRLabel.getY());

        this.window.addShape(raceLabel);
        this.window.addShape(CFRLabel);

    }

    /**
     * Called when the associated button is clicked
     * @param button the button
     */
    public void clickedSortByAlpha(Button button) {

        for (StateData state: stateData) {
            state.sortByAlphabet();
        }
        updateShowedState(currentState);
    }

    /**
     * Called when the associated button is clicked
     * @param button the button
     */
    public void clickedSortByCFR(Button button) {

        for (StateData state: stateData) {
            state.sortByCaseFatalityRatio();
        }
        updateShowedState(currentState);
    }

    /**
     * Called when the associated StateButton is clicked
     * @param button the button
     */
    public void clickedState(Button button) {
        //will always be a StateButton
        StateButton cast = (StateButton)button;
        currentState = cast.getState();
        updateShowedState(cast.getState());
    }

    /**
     * Called when Quit is clicked
     * @param button the button used
     */
    public void clickedQuit(Button button) {
        System.exit(0);

    }


    private void updateShowedState(StateData state) {

        this.window.removeAllShapes();
        
        TextShape title = new TextShape(window.getWidth() / 2, 20, currentState.getName() + " Case Fatality Ratio by Race");
        title.setX((window.getWidth() / 2) - (title.getWidth() / 2));
        this.window.addShape(title);
        
        this.buildShapes();
        this.buildLabels(leftBar, state.getLinkedList().get(0));
        this.buildLabels(midLeftBar, state.getLinkedList().get(1));
        this.buildLabels(midBar, state.getLinkedList().get(2));
        this.buildLabels(midRightBar, state.getLinkedList().get(3));
        this.buildLabels(rightBar, state.getLinkedList().get(4));
    }

}
