package model.metroGateStates;

public class StateContext {
    MetroGateState metroGateState;

    public StateContext(){
        metroGateState = new InactiveState();
    }

    public MetroGateState getState(){
        return this.metroGateState;
    }

    public void setState(MetroGateState metroGateState){
        this.metroGateState = metroGateState;
    }
}
