package entity;

import java.util.Date;

public class Trademark {
    private int trademarkId;
    private String trademarkName;
    private String logo;
    private String descriptionTrademark;
    private Date createDate;
    private Date updateDate;

    public Trademark() {
    }

    public Trademark(String trademarkName, String logo, String describeTrademark) {
        this.trademarkName = trademarkName;
        this.logo = logo;
        this.descriptionTrademark = describeTrademark;
    }

    public Trademark(int trademarkId, String trademarkName, String logo, String descriptionTrademark, Date createDate, Date updateDate) {
        this.trademarkId = trademarkId;
        this.trademarkName = trademarkName;
        this.logo = logo;
        this.descriptionTrademark = descriptionTrademark;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Trademark(int trademarkId, String trademarkName, String logo, String descriptionTrademark) {
        this.trademarkId = trademarkId;
        this.trademarkName = trademarkName;
        this.logo = logo;
        this.descriptionTrademark = descriptionTrademark;
    }

    public int getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(int trademarkId) {
        this.trademarkId = trademarkId;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescriptionTrademark() {
        return descriptionTrademark;
    }

    public void setDescriptionTrademark(String descriptionTrademark) {
        this.descriptionTrademark = descriptionTrademark;
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
