package entity;

import java.sql.Date;

public class Voucher {
    private int voucherId;
    private String code;
    private int value;
    private boolean typeSale;
    private boolean status;
    private String describeVoucher;
    private int maxSale;
    private Date startDate;
    private Date endDate;

    public int getMaxSale() {
        return maxSale;
    }

    public void setMaxSale(int maxSale) {
        this.maxSale = maxSale;
    }

    private Date createdDate;
    private Date updatedDate;

    public Voucher() {
    }

    public Voucher(String code, int value, boolean typeSale, boolean status, String describeVoucher, int maxSale, Date startDate, Date endDate) {
        this.code = code;
        this.value = value;
        this.typeSale = typeSale;
        this.status = status;
        this.describeVoucher = describeVoucher;
        this.maxSale = maxSale;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Voucher(int voucherId, String code, int value, boolean typeSale, boolean status, String describeVoucher, int maxSale, Date startDate, Date endDate) {
        this.voucherId = voucherId;
        this.code = code;
        this.value = value;
        this.typeSale = typeSale;
        this.status = status;
        this.describeVoucher = describeVoucher;
        this.maxSale = maxSale;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Voucher(int voucherId, String code, int value, boolean typeSale, boolean status, String describeVoucher, int maxSale, Date startDate, Date endDate, Date createdDate, Date updatedDate) {
        this.voucherId = voucherId;
        this.code = code;
        this.value = value;
        this.typeSale = typeSale;
        this.status = status;
        this.describeVoucher = describeVoucher;
        this.maxSale = maxSale;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isTypeSale() {
        return typeSale;
    }

    public void setTypeSale(boolean typeSale) {
        this.typeSale = typeSale;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescribeVoucher() {
        return describeVoucher;
    }

    public void setDescribeVoucher(String describeVoucher) {
        this.describeVoucher = describeVoucher;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
