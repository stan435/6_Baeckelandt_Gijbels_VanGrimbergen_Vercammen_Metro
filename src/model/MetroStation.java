package model;

import java.util.HashMap;
import java.util.Map;

public class MetroStation {
    private Map<Integer, MetroGate> metroGates = new HashMap<>();

    public MetroStation(){
        for (int i = 0; i < 3; i++) {
            metroGates.put(i+ 1,new MetroGate(0));

        }
    }

    public MetroGate getmetroGate(int gateId){
        return metroGates.get(gateId);
    }

    public String scanMetroGate(int getid, MetroCard metroCard){
       String result = metroGates.get(getid).scan(metroCard);
       return result;
    }

    public String walkThroughGate(int getid, MetroCard metrocard){
        return metroGates.get(getid).walkThrough(metrocard);
    }

    public void closeMetroStation(MetroCard metroCard){
        for(MetroGate metroGate: metroGates.values()){
            metroGate.closeMetroStation(metroCard);
        }
    }

    public String activateGate(int getid){
        return metroGates.get(getid).activate();
    }
    public String deactivateGate(int getid){
        return metroGates.get(getid).deactivate();
    }

}
