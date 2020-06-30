package bo.edu.ucb.sis.piratebay.model;

public class CompletedOrderModel {
    private Integer orderId;
    private Integer warehouseId;
    private Integer customerId;
    private Integer orderStatus;
    private String paidOrderDate;
    private String preparedOrderDate;
    private String dispatchedOrderDate;
    private String deliveredOrderDate;
    private String firstName,firstSurname,address;
    private Integer status;

    public CompletedOrderModel(Integer orderId, Integer warehouseId, Integer customerId, Integer orderStatus, String paidOrderDate, String preparedOrderDate, String dispatchedOrderDate, String deliveredOrderDate, String firstName, String firstSurname, String address, Integer status) {
        this.orderId = orderId;
        this.warehouseId = warehouseId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.paidOrderDate = paidOrderDate;
        this.preparedOrderDate = preparedOrderDate;
        this.dispatchedOrderDate = dispatchedOrderDate;
        this.deliveredOrderDate = deliveredOrderDate;
        this.firstName = firstName;
        this.firstSurname = firstSurname;
        this.address = address;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaidOrderDate() {
        return paidOrderDate;
    }

    public void setPaidOrderDate(String paidOrderDate) {
        this.paidOrderDate = paidOrderDate;
    }

    public String getPreparedOrderDate() {
        return preparedOrderDate;
    }

    public void setPreparedOrderDate(String preparedOrderDate) {
        this.preparedOrderDate = preparedOrderDate;
    }

    public String getDispatchedOrderDate() {
        return dispatchedOrderDate;
    }

    public void setDispatchedOrderDate(String dispatchedOrderDate) {
        this.dispatchedOrderDate = dispatchedOrderDate;
    }

    public String getDeliveredOrderDate() {
        return deliveredOrderDate;
    }

    public void setDeliveredOrderDate(String deliveredOrderDate) {
        this.deliveredOrderDate = deliveredOrderDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
