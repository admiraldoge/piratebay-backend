package bo.edu.ucb.sis.piratebay.model;

public class OrderProblemModel {
    private Integer orderId,problemId,orderStatus;
    private String title,date,problemDescription;

    public OrderProblemModel(Integer orderId, Integer problemId, Integer orderStatus, String title, String date, String problemDescription) {
        this.orderId = orderId;
        this.problemId = problemId;
        this.orderStatus = orderStatus;
        this.title = title;
        this.date = date;
        this.problemDescription = problemDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }
}
