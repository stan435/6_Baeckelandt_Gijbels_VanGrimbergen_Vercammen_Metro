package model.TicketpriceDecorator;

import model.MetroCard;

public class BasicTicketPrice extends TicketPrice{


    public BasicTicketPrice(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText() {
        return "Basic price of ride is 2,10$";
    }

    @Override
    public double getPrice() {
        return 2.15;
    }
}
