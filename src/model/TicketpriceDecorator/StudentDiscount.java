package model.TicketpriceDecorator;

import model.MetroCard;

public class StudentDiscount extends TicketPriceDiscountDecorator{

    public StudentDiscount(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText() {
        return super.getTicketPrice().getPriceText() + "- 0.25$ student discount";
    }

    @Override
    public double getPrice() {
        return super.getTicketPrice().getPrice() - 0.25;
    }
}
