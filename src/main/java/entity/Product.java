/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author 
 */
public class Product {
    private int productId;
	private String productName;
	private String img;
	private String img1;
	private String img2;
	private String img3;
	private int priceProduct;
	private int typeProductId;
	private int sizeId;
	private int trademarkId;
	private int quantity;
	private String describeProduct;
	private Date createDate;
	private Date updateDate;
	private String sizeName;
	private String trademarkName;
	private String productTypeName;
	private float discountPercentage;
	private int priceAfterDiscount;
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Product() {
	}

	public Product(String productName, String img, String img1, String img2, String img3, int priceProduct, int typeProductId, int sizeId, int trademarkId, int quantity, String describeProduct) {
		this.productName = productName;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.priceProduct = priceProduct;
		this.typeProductId = typeProductId;
		this.sizeId = sizeId;
		this.trademarkId = trademarkId;
		this.quantity = quantity;
		this.describeProduct = describeProduct;
	}

	public Product(int productId, String productName, String img, String img1, String img2, String img3, int priceProduct, int typeProductId, int sizeId, int trademarkId, int quantity, String describeProduct) {
		this.productId = productId;
		this.productName = productName;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.priceProduct = priceProduct;
		this.typeProductId = typeProductId;
		this.sizeId = sizeId;
		this.trademarkId = trademarkId;
		this.quantity = quantity;
		this.describeProduct = describeProduct;
	}

	public Product(int productId, String productName, String img, String img1, String img2, String img3, int priceProduct, int typeProductId, int sizeId, int trademarkId, int quantity, String describeProduct, Date createDate, Date updateDate, boolean status, String productTypeName, String sizeName, String trademarkName, float discountPercentage, int priceAfterDiscount) {
		this.productId = productId;
		this.productName = productName;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.priceProduct = priceProduct;
		this.typeProductId = typeProductId;
		this.sizeId = sizeId;
		this.trademarkId = trademarkId;
		this.quantity = quantity;
		this.describeProduct = describeProduct;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
		this.sizeName = sizeName;
		this.trademarkName = trademarkName;
		this.productTypeName = productTypeName;
		this.discountPercentage = discountPercentage;
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(int priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public Product(int productId, String productName, String img, String img1, String img2, String img3, int priceProduct, int typeProductId, int sizeId, int trademarkId, int quantity, String describeProduct, Date createDate, Date updateDate, boolean status,String productTypeName, String sizeName, String trademarkName ) {
		this.productId = productId;
		this.productName = productName;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.priceProduct = priceProduct;
		this.typeProductId = typeProductId;
		this.sizeId = sizeId;
		this.trademarkId = trademarkId;
		this.quantity = quantity;
		this.describeProduct = describeProduct;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
		this.sizeName = sizeName;
		this.trademarkName = trademarkName;
		this.productTypeName = productTypeName;
	}


	public Product(int productId, String productName, String img, String img1, String img2, String img3, int priceProduct, int typeProductId, int sizeId, int trademarkId, int quantity, String describeProduct, Date createDate, Date updateDate, boolean status) {
		this.productId = productId;
		this.productName = productName;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.priceProduct = priceProduct;
		this.typeProductId = typeProductId;
		this.sizeId = sizeId;
		this.trademarkId = trademarkId;
		this.quantity = quantity;
		this.describeProduct = describeProduct;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	public Product(int productId, String productName, String img, String img1, String img2, String img3, int priceProduct, int typeProductId, int sizeId, int trademarkId, int quantity, String describeProduct, Date createDate, Date updateDate, boolean status, int priceAfterDiscount) {
		this.productId = productId;
		this.productName = productName;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.priceProduct = priceProduct;
		this.typeProductId = typeProductId;
		this.sizeId = sizeId;
		this.trademarkId = trademarkId;
		this.quantity = quantity;
		this.describeProduct = describeProduct;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public int getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}

	public int getTypeProductId() {
		return typeProductId;
	}

	public void setTypeProductId(int typeProductId) {
		this.typeProductId = typeProductId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getTrademarkId() {
		return trademarkId;
	}

	public void setTrademarkId(int trademarkId) {
		this.trademarkId = trademarkId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescribeProduct() {
		return describeProduct;
	}

	public void setDescribeProduct(String describeProduct) {
		this.describeProduct = describeProduct;
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

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getTrademarkName() {
		return trademarkName;
	}

	public void setTrademarkName(String trademarkName) {
		this.trademarkName = trademarkName;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", img='" + img + '\'' +
				", img1='" + img1 + '\'' +
				", img2='" + img2 + '\'' +
				", img3='" + img3 + '\'' +
				", priceProduct=" + priceProduct +
				", typeProductId=" + typeProductId +
				", sizeId=" + sizeId +
				", trademarkId=" + trademarkId +
				", quantity=" + quantity +
				", describeProduct='" + describeProduct + '\'' +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				", sizeName='" + sizeName + '\'' +
				", trademarkName='" + trademarkName + '\'' +
				", productTypeName='" + productTypeName + '\'' +
				", discountPercentage=" + discountPercentage +
				", priceAfterDiscount=" + priceAfterDiscount +
				", status=" + status +
				'}';
	}
}
