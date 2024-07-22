package entity;

import java.sql.Date;

public class Discount {
    private int discountId;
    private float discountPercentage;
    private Date startDate;
    private Date endDate;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Discount() {
    }

    public Discount(int discountId, float discountPercentage, Date startDate, Date endDate, boolean status) {
        this.discountId = discountId;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Discount(int discountId, float discountPercentage, Date startDate, Date endDate) {
        this.discountId = discountId;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
