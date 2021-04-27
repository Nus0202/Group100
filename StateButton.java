package prj5;

import cs2.Button;

public class StateButton extends Button{
    
    private StateData state;
    
    public StateButton(StateData State) {
        this.state = State;
    }
    
    public StateData getState() {
        return state;
    }
}
