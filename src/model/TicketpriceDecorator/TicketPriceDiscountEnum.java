package model.TicketpriceDecorator;

public enum TicketPriceDiscountEnum {
    AGE64PLUSDISCOUNT("model.TicketpriceDecorator.Age64PlusDiscount"),
    CHRISTMASLEAVEDISCOUNT("model.TicketpriceDecorator.ChristmasLeaveDiscount"),
    STUDENTDISCOUNT("model.TicketpriceDecorator.StudentDiscount"),
    FREQUENTTRAVELERDISCOUNT("model.TicketpriceDecorator.FrequentDiscountTravellerDiscount");

    private final String klassenaam;

    TicketPriceDiscountEnum(String klassenaam){
        this.klassenaam =  klassenaam;
    }

    public String getClassName() {
        return this.klassenaam;
    }
}
