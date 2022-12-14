package model.TicketpriceDecorator;

import model.MetroCard;
import model.database.LoadSaveStrategies.LoadSaveStrategy;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class TicketPriceFactory {

    public static TicketPrice createTicketPrice(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream("./bestanden/settings.properties");
        properties.load(is);
        String name = properties.getProperty("discount");
        String[] list = name.split(",");

        if(list.length != 0){
            for (int i = 0; i < list.length; i++) {
                TicketPriceDiscountEnum discount = TicketPriceDiscountEnum.valueOf(list[i].toUpperCase());
                String className = discount.getClassName();
                try {
                    Class<?> cipherClass = Class.forName(className);
                    TicketPrice ticketPrice = (TicketPrice) cipherClass.newInstance();
                    ticketPrice.getPrice();
                    ticketPrice.getPriceText();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid discount");
                }
            }
        }
        return null;
    }
}
