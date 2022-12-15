package model.metroGateStates;

import model.MetroCard;

import java.time.YearMonth;

public class ClosedState implements MetroGateState{

    @Override
    public String walkThroughGate(StateContext stateContext, MetroCard metroCard) {
        return "Can not walk through \n closed gate";
    }

    @Override
    public String scanMetroGate(StateContext stateContext, MetroCard metroCard){
        YearMonth yearMonth = YearMonth.now();
        if(metroCard.getDate().plusYears(1).isBefore(yearMonth)){
            return "metrocard " + metroCard.getId() + " is expired";
        }
        if(metroCard.getBeschikbaar() <= 0){
            return "metrocard " + metroCard.getId() + " has \n no rides left";
        }
        stateContext.setState(new OpenState());
        return "metrocard " + metroCard.getId() + " is scanned";
    }

    @Override
    public String deactivateGate(StateContext stateContext) {
        stateContext.setState(new InactiveState());
        return "gate is inactive";
    }


}
