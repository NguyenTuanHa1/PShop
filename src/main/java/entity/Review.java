package entity;

import java.util.Date;

public class Review {
	  private int reviewId;
	  private int productId;
	  private int userId;
	  private int starQuantity;
	  private String content;
	  private Date createdDate;
	  private Date updatedDate;
	  private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	private String avatar;
	  private String productName;

	  public Review() {
	  }

	  public Review(int reviewId, int productId, int userId, int starQuantity, String content, Date createdDate, String userName, String productName) {
	    this.reviewId = reviewId;
	    this.productId = productId;
	    this.userId = userId;
	    this.starQuantity = starQuantity;
	    this.content = content;
	    this.createdDate = createdDate;
	    this.name = userName;
	    this.productName = productName;
	  }

	public Review(int reviewId, int productId, int userId, int starQuantity, String content, Date createdDate, Date updatedDate,String userName, String avatar,String productName) {
		this.reviewId = reviewId;
		this.productId = productId;
		this.userId = userId;
		this.starQuantity = starQuantity;
		this.content = content;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.name = userName;
		this.productName = productName;
		this.avatar = avatar;
	}
	  public Review(int productId, int userId, int starQuantity, String content, Date createdDate) {
	    this.productId = productId;
	    this.userId = userId;
	    this.starQuantity = starQuantity;
	    this.content = content;
	    this.createdDate = createdDate;
	  }

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStarQuantity() {
		return starQuantity;
	}

	public void setStarQuantity(int starQuantity) {
		this.starQuantity = starQuantity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
