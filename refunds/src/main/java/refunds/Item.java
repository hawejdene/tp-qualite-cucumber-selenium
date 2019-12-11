package refunds;

import java.util.Date;

public class Item {
    private int id;
    private int quantity;
    private int boughtAt;
    private int garentiDay;
    private boolean goodCondition;
    private String type;
    private boolean sales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public boolean isSales() {
        return sales;
    }

    public void setSales(boolean sales) {
        this.sales = sales;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(int boughtAt) {
        this.boughtAt = boughtAt;
    }

    public int getGarentiDay() {
        return garentiDay;
    }

    public void setGarentiDay(int garentiDay) {
        this.garentiDay = garentiDay;
    }

    public boolean getGoodCondition() {
        return goodCondition;
    }

    public void setGoodCondition(boolean goodCondition) {
        this.goodCondition = goodCondition;
    }
}
