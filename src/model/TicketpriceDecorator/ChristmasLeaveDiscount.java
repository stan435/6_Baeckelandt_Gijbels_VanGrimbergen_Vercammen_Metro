package model.TicketpriceDecorator;

import model.MetroCard;

public class ChristmasLeaveDiscount extends TicketPriceDiscountDecorator{


    public ChristmasLeaveDiscount(TicketPrice ticketPrice, int rides) {
        super(ticketPrice, rides);
    }

    @Override
    public String getPriceText(){
        return super.getPriceText() + "- 0.10$ Christmas leave discount";
    }

    @Override
    public double getPrice() {
        return super.getPrice() - (0.10 * super.getRides());
    }
}
