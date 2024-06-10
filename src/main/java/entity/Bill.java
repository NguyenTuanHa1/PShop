package entity;

import java.sql.Date;

public class Bill {
    private int billId;
    private int userId;
    private String userName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String district;
    private String statusBill;
    private String voucherCode;
    private float vat;
    private String note;
    private int transportId;
    private int paymentId;
    private int employeeId;
    private Date createdDate;
    private Date updatedDate;
    private User user;
    private User employee;
    private Transport transport;
    private Payment payment;
    private Voucher voucher;
    private String paymentName;
    private String transportName;
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    private int totalPrice;

    public Bill() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Bill(int billId, int userId, String userName, String email, String city, String district, String phone, String address, String note, String statusBill, String voucherCode, float vat, int transportId, int paymentId, int employeeId, Date createdDate, Date updatedDate, User user, User employee, Transport transport, Payment payment, Voucher voucher) {
        this.billId = billId;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.district = district;
        this.statusBill = statusBill;
        this.voucherCode = voucherCode;
        this.vat = vat;
        this.transportId = transportId;
        this.paymentId = paymentId;
        this.note = note;
        this.employeeId = employeeId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
        this.employee = employee;
        this.transport = transport;
        this.payment = payment;
        this.voucher = voucher;
    }

    public Bill(int userId, String userName, String email, String city, String district, String phone, String address, String note, String voucherCode, int transportId, int paymentId, float vat) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.district = district;
        this.note = note;
        this.voucherCode = voucherCode;
        this.vat = vat;
        this.transportId = transportId;
        this.paymentId = paymentId;
    }

    // userId, userName, email, city, district, phone, address, note, voucherCode, transportId, paymentId
    public Bill(int userId, String userName, String email, String city, String district, String phone, String address, String note, String voucherCode, int transportId, int paymentId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.district = district;
        this.note = note;
        this.voucherCode = voucherCode;
        this.transportId = transportId;
        this.paymentId = paymentId;
    }

    public Bill(int userId, String userName, String email, String city, String district, String phone, String address, String note, String voucherCode, int transportId, int paymentId, int totalPrice) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.district = district;
        this.note = note;
        this.voucherCode = voucherCode;
        this.transportId = transportId;
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
    }

    public Bill(int billId, int userId, String userName, String email, String city, String district, String phone, String address, String note, String statusBill, String voucherCode, float vat, int transportId, int paymentId, int employeeId, int totalPrice,Date createdDate, Date updatedDate) {
        this.billId = billId;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.district = district;
        this.statusBill = statusBill;
        this.voucherCode = voucherCode;
        this.vat = vat;
        this.note = note;
        this.transportId = transportId;
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public Bill(int billId, int userId, String userName, String email, String city, String district, String phone, String address, String note, String statusBill, String voucherCode, float vat, int transportId, int paymentId, int employeeId, int totalPrice, Date createdDate, Date updatedDate, String paymentName, String transportName) {
        this.billId = billId;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.district = district;
        this.statusBill = statusBill;
        this.voucherCode = voucherCode;
        this.vat = vat;
        this.note = note;
        this.transportId = transportId;
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.paymentName = paymentName;
        this.transportName = transportName;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStatusBill() {
        return statusBill;
    }

    public void setStatusBill(String statusBill) {
        this.statusBill = statusBill;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
