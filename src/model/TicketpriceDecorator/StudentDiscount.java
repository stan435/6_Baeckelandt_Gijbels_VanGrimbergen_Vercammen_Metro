package model.TicketpriceDecorator;

import model.MetroCard;

public class StudentDiscount extends TicketPriceDiscountDecorator{

    public StudentDiscount(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    @Override
    public String getPriceText() {
        if(getStudent()){
            return super.getTicketPrice().getPriceText() + "- 0.25$ student discount";
        }
        return super.getTicketPrice().getPriceText();
    }

    @Override
    public double getPrice() {
        if(getStudent()){
            return super.getTicketPrice().getPrice() - (0.25 * getRides());
        }
        return super.getTicketPrice().getPrice();
    }
}
