package model.TicketpriceDecorator;

import model.MetroCard;

public class ChristmasLeaveDiscount extends TicketPriceDiscountDecorator{


    public ChristmasLeaveDiscount(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText() {
        return super.getTicketPrice().getPriceText() + "- 0.10$ Christmas leave discount";
    }

    @Override
    public double getPrice() {
        return super.getTicketPrice().getPrice() - 0.10;
    }
}
