package model.metroGateStates;


public class InactiveState implements MetroGateState{


    @Override
    public String activateGate(StateContext stateContext) {
        stateContext.setState(new ClosedState());
        return "gate is active";
    }
}
