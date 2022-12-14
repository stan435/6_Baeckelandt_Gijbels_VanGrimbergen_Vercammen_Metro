package model.metroGateStates;

public class StateContext {
    MetroGateState metroGateState;

    public StateContext(){
        metroGateState = new ClosedState();
    }

    public MetroGateState getState(){
        return this.metroGateState;
    }

    public void setState(MetroGateState metroGateState){
        this.metroGateState = metroGateState;
    }
}
