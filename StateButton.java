package prj5;

import cs2.Button;

public class StateButton extends Button{
    
    private String state;
    
    public StateButton(String State) {
        this.state = State;
    }
    
    public String getState() {
        return state;
    }
}
