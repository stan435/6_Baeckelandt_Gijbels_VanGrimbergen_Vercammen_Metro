package model.database.utilities;

import model.MetroCard;
import model.database.utilities.TekstLoadTemplate;

import java.time.YearMonth;


public class MetroCardTekstReader extends TekstLoadTemplate {

    @Override
    protected MetroCard maakObject(String[] tokens) {

        MetroCard metroCard = new MetroCard(Integer.parseInt(tokens[0]), YearMonth.parse(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return metroCard;
    }

    protected String getKey(String[] tokens){
        return tokens[1];
    }

}
