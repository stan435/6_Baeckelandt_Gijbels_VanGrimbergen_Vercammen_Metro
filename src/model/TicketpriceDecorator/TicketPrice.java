package model.TicketpriceDecorator;

import model.MetroCard;

public abstract class TicketPrice {
    private Boolean is26Min, is64Plus, isStudent;
    private MetroCard attribute;
    private int rides;

    public TicketPrice(){

    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public void setIs26Min(Boolean is26Min) {
        this.is26Min = is26Min;
    }

    public void setIs64Plus(Boolean is64Plus) {
        this.is64Plus = is64Plus;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    public void setAttribute(MetroCard attribute) {
        this.attribute = attribute;
    }

    public Boolean getIs26Min() {
        return is26Min;
    }

    public Boolean getIs64Plus() {
        return is64Plus;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public MetroCard getAttribute() {
        return attribute;
    }

    public int getRides() {
        return rides;
    }

    public abstract String getPriceText();
    public abstract  double getPrice();
}
