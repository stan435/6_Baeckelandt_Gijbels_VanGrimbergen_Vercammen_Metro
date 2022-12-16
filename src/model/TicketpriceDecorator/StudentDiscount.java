package model.TicketpriceDecorator;

import model.MetroCard;

public class StudentDiscount extends TicketPriceDiscountDecorator{

    public StudentDiscount(TicketPrice ticketPrice, int rides) {
        super(ticketPrice, rides);
    }

    @Override
    public String getPriceText() {
        return super.getPriceText() + "- 0.25$ student discount";

    }

    @Override
    public double getPrice() {
        return super.getPrice() - (0.25 * super.getRides());

    }
}
