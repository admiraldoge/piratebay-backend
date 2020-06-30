package bo.edu.ucb.sis.piratebay.model;

import java.util.Date;

public class OrderModel {
    private Integer orderId;
    private Integer warehouseId;
    private Integer customerId;
    private Date date;
    private Integer status;
    private Integer orderStatus;

    public OrderModel(Integer orderId, Integer warehouseId, Integer customerId, Integer orderStatus, Date date, Integer status) {
        this.orderId = orderId;
        this.warehouseId = warehouseId;
        this.customerId = customerId;
        this.date = date;
        this.status = status;
        this.orderStatus = orderStatus;
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

    public Integer getOrderUserId() {
        return customerId;
    }

    public void setOrderUserId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
