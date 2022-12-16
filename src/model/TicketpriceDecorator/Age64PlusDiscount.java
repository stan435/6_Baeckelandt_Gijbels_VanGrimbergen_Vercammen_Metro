package model.TicketpriceDecorator;

import model.MetroCard;

public class Age64PlusDiscount extends TicketPriceDiscountDecorator{

    public Age64PlusDiscount(TicketPrice ticketPrice, int rides) {
        super(ticketPrice, rides);
    }

    @Override
    public String getPriceText() {
        return super.getPriceText() + "- 0.15$ 64+ age discount";
    }

    @Override
    public double getPrice() {

        double result = super.getPrice() - (0.15 * super.getRides());
        return result;
    }
}
