package model.metroGateStates;

import model.MetroCard;

public class OpenState implements MetroGateState{


    @Override
    public String scanMetroGate(StateContext stateContext, MetroCard metroCard) {
        return "Can not scan open gate";
    }

    @Override
    public String walkThroughGate(StateContext stateContext, MetroCard metroCard) {
        stateContext.setState(new ClosedState());
        return "Card " + metroCard.getId() + "passed gate";
    }
}
