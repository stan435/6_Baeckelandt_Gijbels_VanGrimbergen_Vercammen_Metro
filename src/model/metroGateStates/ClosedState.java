package model.metroGateStates;

import model.MetroCard;

public class ClosedState implements MetroGateState{

    @Override
    public String scanMetroGate(StateContext stateContext, MetroCard metroCard){
        stateContext.setState(new OpenState());
        return "scanned card";
    }
}
