package entity;

import java.util.Date;

public class Size {
    private int sizeId;
    private String sizeName;
    private String describeSize;
    private String weight;
    private Date createDate;
    private Date updateDate;

    public Size() {
    }

    public Size(String sizeName, String describeSize, String weight) {
        this.sizeName = sizeName;
        this.describeSize = describeSize;
        this.weight = weight;
    }

    public Size(int sizeId, String sizeName, String describeSize, String weight) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.describeSize = describeSize;
        this.weight = weight;
    }
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getDescribeSize() {
        return describeSize;
    }

    public void setDescribeSize(String describeSize) {
        this.describeSize = describeSize;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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

    public Size(int sizeId, String sizeName, String describeSize, String weight, Date createDate, Date updateDate) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.describeSize = describeSize;
        this.weight = weight;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


}
