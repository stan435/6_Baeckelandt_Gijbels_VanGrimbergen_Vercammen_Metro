package model.metroGateStates;

import model.MetroCard;

public interface MetroGateState {

    public default String scanMetroGate(StateContext stateContext, MetroCard metroCard){
        return "can not scan card";
    }
}
