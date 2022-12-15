package model.metroGateStates;

import model.MetroCard;

public interface MetroGateState {

    public default String scanMetroGate(StateContext stateContext, MetroCard metroCard){
        return "can not scan card " + metroCard.getId();
    }

    public default String walkThroughGate(StateContext stateContext, MetroCard metroCard){
        return "can not walk through gate";
    }

    public default String activateGate(StateContext stateContext){
        return "gate already active";
    }

    public default String deactivateGate(StateContext stateContext){
        return "gate cannot be deactivated";
    }

}
