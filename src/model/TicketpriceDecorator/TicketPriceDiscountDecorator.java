package model.TicketpriceDecorator;

import model.MetroCard;

public abstract class TicketPriceDiscountDecorator extends TicketPrice {
    private TicketPrice ticketPrice;

    public TicketPriceDiscountDecorator(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) {
        super(is26Min, is64Plus, isStudent, metroCard, rides);
    }

    public TicketPrice getTicketPrice(){
        return this.ticketPrice;
    }

}
