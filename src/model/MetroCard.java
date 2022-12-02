package model;


import java.time.YearMonth;

public class MetroCard {
    private int id,int1,int2;
    private YearMonth date;

    public MetroCard(int id, YearMonth date, int int1, int int2){
        this.id = id;
        this.date = date;
        this.int1 = int1;
        this.int2 = int2;
    }

    public int getId() {
        return id;
    }

    public int getInt1() {
        return int1;
    }

    public int getInt2() {
        return int2;
    }

    public YearMonth getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }
}
