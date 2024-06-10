package entity;

import java.util.Date;

public class Cart {
    private int cartId;
    private int userId;
    private Date createdDate;
    private User user;

    public Cart() {
    }

    public Cart(int cartId, int userId, Date createdDate) {
        this.cartId = cartId;
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public Cart(int userId, Date createdDate) {
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public Cart(int userId) {
        this.userId = userId;
    }

    public Cart(int cartId, int userId, Date createdDate, User user) {
        this.cartId = cartId;
        this.userId = userId;
        this.createdDate = createdDate;
        this.user = user;
    }

    public Cart(int cartId, User user, Date createdDate) {
        this.cartId = cartId;
        this.user = user;
        this.createdDate = createdDate;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
