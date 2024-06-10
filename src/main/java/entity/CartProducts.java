package entity;

import java.util.Date;

public class CartProducts {
    private int cartItemId;
    private int cartId;
    private int productId;
    private int quantity;
    private int discountId;
    private Date createdDate;

    private Product product;
    private Discount discount;
    private Cart cart;
    private int priceAfterDiscount;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(int priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public CartProducts() {
    }

    public CartProducts(int cartItemId, int cartId, int productId, int quantity, int discountId, Date createdDate) {
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.discountId = discountId;
        this.createdDate = createdDate;
    }

    public CartProducts(Product product, Discount discount, Cart cart, int quantity, int priceAfterDiscount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.priceAfterDiscount = priceAfterDiscount;
        this.cart = cart;
    }

    public CartProducts(Product product, Discount discount, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
