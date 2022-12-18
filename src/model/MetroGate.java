package model;

import model.metroGateStates.OpenState;
import model.metroGateStates.StateContext;

import java.util.Objects;

public class MetroGate {
    StateContext stateContext;
    private int scannedCards;


    public MetroGate(int scannedCards){
        setScannedCards(scannedCards);
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

    public int getScannedCards() {
        return scannedCards;
    }

    public void setScannedCards(int scannedCards) {
        this.scannedCards = scannedCards;
    }

    public void closeMetroStation(MetroCard metroCard){
        stateContext.getState().walkThroughGate(stateContext, metroCard);
        stateContext.getState().deactivateGate(stateContext);
    }
}
