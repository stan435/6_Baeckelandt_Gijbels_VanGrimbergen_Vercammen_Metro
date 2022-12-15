package model;

import java.util.HashMap;
import java.util.Map;

public class MetroStation {
    private Map<Integer, MetroGate> metroGates = new HashMap<>();

    public MetroStation(){
        for (int i = 0; i < 3; i++) {
            metroGates.put(i+ 1,new MetroGate());

        }
    }

    public String scanMetroGate(int getid, MetroCard metroCard){
       return metroGates.get(getid).scan(metroCard);
    }

    public String walkThroughGate(int getid, MetroCard metrocard){
        return metroGates.get(getid).walkThrough(metrocard);
    }

    public String activateGate(int getid){
        return metroGates.get(getid).activate();
    }
    public String deactivateGate(int getid){
        return metroGates.get(getid).deactivate();
    }

}
