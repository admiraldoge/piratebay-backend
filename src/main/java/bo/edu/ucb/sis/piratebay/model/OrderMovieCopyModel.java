package bo.edu.ucb.sis.piratebay.model;

public class OrderMovieCopyModel {
    Integer movieId;
    Integer preparedQuantity;

    public OrderMovieCopyModel(Integer movieId, Integer preparedQuantity) {
        this.movieId = movieId;
        this.preparedQuantity = preparedQuantity;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getPreparedQuantity() {
        return preparedQuantity;
    }

    public void setPreparedQuantity(Integer preparedQuantity) {
        this.preparedQuantity = preparedQuantity;
    }
}
