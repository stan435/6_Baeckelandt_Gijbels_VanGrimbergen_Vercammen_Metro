package model.TicketpriceDecorator;

import model.MetroCard;

public abstract class TicketPriceDiscountDecorator extends TicketPrice {
    private TicketPrice ticketPrice;
    private int rides;

    public TicketPriceDiscountDecorator(TicketPrice ticketPrice, int rides) {
        this.ticketPrice = ticketPrice;
        this.rides = rides;
    }

    public TicketPrice getTicketPrice(){
        return this.ticketPrice;
    }

    public int getRides(){
        return this.rides;
    }

    @Override
    public double getPrice() {
        return ticketPrice.getPrice();
    }

    @Override
    public String getPriceText() {
        return ticketPrice.getPriceText();
    }

}
