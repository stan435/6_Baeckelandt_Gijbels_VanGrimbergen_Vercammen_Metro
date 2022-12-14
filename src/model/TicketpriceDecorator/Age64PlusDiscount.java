package model.TicketpriceDecorator;

import model.MetroCard;

public class Age64PlusDiscount extends TicketPriceDiscountDecorator{


    public Age64PlusDiscount(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText() {
        return super.getTicketPrice().getPriceText() + "- 0.15$ 64+ age discount";
    }

    @Override
    public double getPrice() {
        return super.getTicketPrice().getPrice() - 0.15;
    }
}
