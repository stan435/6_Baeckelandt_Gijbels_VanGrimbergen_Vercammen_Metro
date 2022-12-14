package model;

import java.util.HashMap;
import java.util.Map;

public class MetroStation {
    private Map<Integer, MetroGate> metroGates = new HashMap<>();

    public MetroStation(){
        for (int i = 0; i < 3; i++) {
            metroGates.put(i,new MetroGate());
        }
    }

    public String scanMetroGate(int getid, MetroCard metroCard){
       return metroGates.get(getid).scan(metroCard);
    }
}
