package model.metroGateStates;

import model.MetroCard;

public class InactiveState implements MetroGateState{

    @Override
    public String scanMetroGate(StateContext stateContext, MetroCard metroCard) {
        return null;
    }

    @Override
    public String walkThroughGate(StateContext stateContext, MetroCard metroCard) {
        return null;
    }
}
