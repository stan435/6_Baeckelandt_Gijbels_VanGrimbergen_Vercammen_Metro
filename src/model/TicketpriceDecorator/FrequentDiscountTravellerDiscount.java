package model.TicketpriceDecorator;

import model.MetroCard;

public class FrequentDiscountTravellerDiscount extends TicketPriceDiscountDecorator{


    public FrequentDiscountTravellerDiscount(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
