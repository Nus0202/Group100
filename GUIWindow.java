package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;

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
        
        //creates buttons
        
        //looks at data and assigns button/shapes (their position, text, etc)
    }
}
