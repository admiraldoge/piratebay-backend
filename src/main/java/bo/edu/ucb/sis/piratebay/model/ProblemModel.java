package bo.edu.ucb.sis.piratebay.model;

public class ProblemModel {
    private Integer orderStatus;
    private String title,date,problemDescription;

    public ProblemModel(Integer orderStatus, String title, String date, String problemDescription) {
        this.orderStatus = orderStatus;
        this.title = title;
        this.date = date;
        this.problemDescription = problemDescription;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }
}
