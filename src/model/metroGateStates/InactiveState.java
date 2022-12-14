package model.metroGateStates;

import model.MetroCard;

public class InactiveState implements MetroGateState{

    @Override
    public String scanMetroGate(StateContext stateContext, MetroCard metroCard) {
        return null;
    }
}
