package model.TicketpriceDecorator;

import model.MetroCard;

public class BasicTicketPrice extends TicketPrice{
    int rides;

    public BasicTicketPrice(int rides) {
        this.rides = rides;
    }

    @Override
    public String getPriceText() {
        return "Starting price of ride is 2,10$ ";
    }

    @Override
    public double getPrice() {
        return 2.10 * rides;
    }
}
