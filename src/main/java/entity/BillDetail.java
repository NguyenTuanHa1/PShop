package entity;

import java.sql.Date;

public class BillDetail {
    private int billDetailId;
    private int productId;
    private int billId;
    private int quantity;
    private int priceBillDetail;
    private Date createdDate;
    private Date updatedDate;
    private Product product;
    private Bill bill;
    private Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BillDetail() {
    }

    public BillDetail(int billDetailId, int productId, int billId, int quantity, int priceBillDetail, Date createdDate, Date updatedDate, Product product, Discount discount) {
        this.billDetailId = billDetailId;
        this.productId = productId;
        this.billId = billId;
        this.quantity = quantity;
        this.priceBillDetail = priceBillDetail;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.product = product;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "billDetailId=" + billDetailId +
                ", productId=" + productId +
                ", billId=" + billId +
                ", quantity=" + quantity +
                ", priceBillDetail=" + priceBillDetail +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", product=" + product +
                ", bill=" + bill +
                ", discount=" + discount +
                '}';
    }

    public BillDetail(int billId, Product product, Discount discount, int quantity, int priceBillDetail) {
        this.billId = billId;
        this.product = product;
        this.quantity = quantity;
        this.priceBillDetail = priceBillDetail;
    }

    public int getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(int billDetailId) {
        this.billDetailId = billDetailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceBillDetail() {
        return priceBillDetail;
    }

    public void setPriceBillDetail(int priceBillDetail) {
        this.priceBillDetail = priceBillDetail;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
