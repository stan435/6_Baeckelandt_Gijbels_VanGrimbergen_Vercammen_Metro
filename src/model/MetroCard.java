package model;


import java.time.YearMonth;

public class MetroCard {
    private int id, beschikbaar, gebruikt;
    private YearMonth date;

    public MetroCard(int id, YearMonth date, int beschikbaar, int gebruikt){
        this.id = id;
        this.date = date;
        this.beschikbaar = beschikbaar;
        this.gebruikt = gebruikt;
    }

    public int getId() {
        return id;
    }

    public int getBeschikbaar() {
        return beschikbaar;
    }

    public int getGebruikt() {
        return gebruikt;
    }

    public YearMonth getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBeschikbaar(int beschikbaar) {
        this.beschikbaar = beschikbaar;
    }

    public void setGebruikt(int gebruikt) {
        this.gebruikt = gebruikt;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }
}
