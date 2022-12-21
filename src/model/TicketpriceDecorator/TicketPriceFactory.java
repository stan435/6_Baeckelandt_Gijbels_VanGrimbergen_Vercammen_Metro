package model.TicketpriceDecorator;

import model.MetroCard;
import model.MetroEventsEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategy;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TicketPriceFactory {
    private String toShowFinal;
    private double priceFinal;

    public TicketPrice createTicketPrice(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream("./bestanden/settings.properties");
        properties.load(is);
        String name = properties.getProperty("discount");
        List<String> items = Arrays.asList(name.split(","));

        TicketPrice price = new BasicTicketPrice(rides);
        double priceAmount = price.getPrice();
        String toShow = price.getPriceText();

        if (is64Plus && items.contains(TicketPriceDiscountEnum.AGE64PLUSDISCOUNT.toString())) {
            price = new Age64PlusDiscount(price, rides);
            toShow = price.getPriceText();
            priceAmount = price.getPrice();

        }
        if (isStudent && items.contains(TicketPriceDiscountEnum.STUDENTDISCOUNT.toString())) {
            price = new StudentDiscount(price, rides);
            toShow = price.getPriceText();
            priceAmount = price.getPrice();

        }

        if (metroCard.getGebruikt() > 50 && items.contains(TicketPriceDiscountEnum.FREQUENTTRAVELERDISCOUNT.toString())) {
            price = new FrequentDiscountTravellerDiscount(price, rides);
            toShow = price.getPriceText();
            priceAmount = price.getPrice();
        }

        if (items.contains(TicketPriceDiscountEnum.CHRISTMASLEAVEDISCOUNT.toString())) {
            price = new ChristmasLeaveDiscount(price, rides);
            toShow = price.getPriceText();
            priceAmount = price.getPrice();

        }
        this.toShowFinal = toShow + "final price: " + String.format("%.2f", price.getPrice());
        this.priceFinal = priceAmount;
        return price;
    }


        public String getTextToShow() {
            return toShowFinal;
        }

        public double getPriceToShow(){
        return priceFinal;
    }


        /*
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

         */
}