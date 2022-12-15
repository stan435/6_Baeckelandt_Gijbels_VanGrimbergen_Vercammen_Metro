package model;

import model.metroGateStates.StateContext;

public class MetroGate {
    StateContext stateContext;

    public MetroGate(){
        this.stateContext = new StateContext();
    }

    public String scan(MetroCard metroCard){
       return stateContext.getState().scanMetroGate(stateContext, metroCard);
    }

    public String walkThrough(MetroCard metroCard){
        return  stateContext.getState().walkThroughGate(stateContext,metroCard);
    }

    public String activate(){
        return stateContext.getState().activateGate(stateContext);
    }
    public String deactivate(){
        return stateContext.getState().deactivateGate(stateContext);
    }


}
