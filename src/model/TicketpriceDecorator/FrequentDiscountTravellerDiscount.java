package model.TicketpriceDecorator;

import model.MetroCard;

public class FrequentDiscountTravellerDiscount extends TicketPriceDiscountDecorator{


    public FrequentDiscountTravellerDiscount(TicketPrice ticketPrice, int rides) {
        super(ticketPrice, rides);
    }

    @Override
    public String getPriceText(){
        return super.getPriceText() + "- 0.20$ frequent traveller discount";

    }

    @Override
    public double getPrice() {
        return super.getPrice() - (0.20 * super.getRides());

    }
}
