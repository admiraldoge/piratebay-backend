package bo.edu.ucb.sis.piratebay.model;

public class OrderMovieModel {
    private Integer orderId;
    private Integer movieId;
    private Integer quantity;
    private Integer warehouseId;
    private Integer preparedQuantity;
    private String name,image;

    public OrderMovieModel(Integer orderId, Integer movieId, Integer quantity, Integer warehouseId, Integer preparedQuantity, String name, String image) {
        this.orderId = orderId;
        this.movieId = movieId;
        this.quantity = quantity;
        this.warehouseId = warehouseId;
        this.preparedQuantity = preparedQuantity;
        this.name = name;
        this.image = image;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPreparedQuantity() {
        return preparedQuantity;
    }

    public void setPreparedQuantity(Integer preparedQuantity) {
        this.preparedQuantity = preparedQuantity;
    }
}
