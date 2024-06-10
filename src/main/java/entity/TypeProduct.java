package entity;

import java.util.Date;

public class TypeProduct {
    private int typeProductId;
    private String typeProductName;
    private String describeType;
    private Date createDate;
    private Date updateDate;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TypeProduct() {
    }

    public TypeProduct(String typeProductName, String describeType) {
        this.typeProductName = typeProductName;
        this.describeType = describeType;
    }

    public TypeProduct(int typeProductId, String typeProductName, String describeType, Date createDate, Date updateDate) {
        this.typeProductId = typeProductId;
        this.typeProductName = typeProductName;
        this.describeType = describeType;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public TypeProduct(int typeProductId, String typeProductName, String describeType) {
        this.typeProductId = typeProductId;
        this.typeProductName = typeProductName;
        this.describeType = describeType;
    }

    public TypeProduct(int typeProductId,String typeProductName, int quantity) {
        this.typeProductId = typeProductId;
        this.typeProductName = typeProductName;
        this.quantity = quantity;
    }

    public int getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(int typeProductId) {
        this.typeProductId = typeProductId;
    }

    public String getTypeProductName() {
        return typeProductName;
    }

    public void setTypeProductName(String typeProductName) {
        this.typeProductName = typeProductName;
    }

    public String getDescribeType() {
        return describeType;
    }

    public void setDescribeType(String describeType) {
        this.describeType = describeType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
