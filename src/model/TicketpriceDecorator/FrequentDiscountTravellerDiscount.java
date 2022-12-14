package model.TicketpriceDecorator;

import model.MetroCard;

public class FrequentDiscountTravellerDiscount extends TicketPriceDiscountDecorator{


    public FrequentDiscountTravellerDiscount(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText(){
        if(getAttribute().getGebruikt() > 50){
            return super.getTicketPrice().getPriceText() + " - 0.20$ frequent traveller discount";
        }
        return super.getTicketPrice().getPriceText();
    }

    @Override
    public double getPrice() {
        if (getAttribute().getGebruikt() > 50) {
            return super.getTicketPrice().getPrice() - (0.20 * getRides());
        }
        return super.getTicketPrice().getPrice();
    }
}
