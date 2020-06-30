package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.*;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findUserIdByUsernameAndPassword(String username, String password) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query = "SELECT user_id FROM \"user\" WHERE username = ? AND UPPER(password) = UPPER(?) ";
        Integer userId = null;
        try {
            userId = jdbcTemplate.queryForObject(query,
                    new Object [] {username, password},
                    Integer.class);
        } catch (Exception ex) {
            //Do nothing
        }
        return userId;
    }

    public List<OrderModel> findAllOrders() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query = "SELECT order_id, warehouse_id, customer_id, order_status, date, status FROM \"order\" WHERE status = 1";
        List<OrderModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<OrderModel>() {
                @Override
                public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new OrderModel(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(3),
                            resultSet.getDate(5),
                            resultSet.getInt(6));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<CompletedOrderModel> findAllCompletedOrders() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query = "select order_id,warehouse_id, c.customer_id, order_status, paid_order_date, prepared_order_date, dispatched_order_date, delivered_order_date, first_name, first_surname, address, o.status\n" +
                "from \"order\" o\n" +
                "join customer c on o.customer_id = c.customer_id\n" +
                "join person p on c.person_id = p.person_id";
        List<CompletedOrderModel> result = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        try {
            result = jdbcTemplate.query(query, new RowMapper<CompletedOrderModel>() {
                @Override
                public CompletedOrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    String ldt1 = "";
                    String ldt2 = "";
                    String ldt3 = "";
                    String ldt4 = "";
                    if(resultSet.getString(5) != null) {
                        ldt1 = resultSet.getString(5);
                    }
                    if(resultSet.getString(6) != null) {
                        ldt2 = resultSet.getString(6);
                    }
                    if(resultSet.getString(7) != null) {
                        ldt3 = resultSet.getString(7);
                    }
                    if(resultSet.getString(8) != null) {
                        ldt4 = resultSet.getString(8);
                    }
                    return new CompletedOrderModel(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            ldt1,
                            ldt2,
                            ldt3,
                            ldt4,
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getInt(12));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<OrderMovieModel> findAllOrderMovies() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query = "select order_id, m.movie_id, om.quantity,m.warehouse_id,om.prepared_quantity, m.name, m.image\n" +
                "from order_movie om\n" +
                "join movie m on om.movie_id = m.movie_id";
        List<OrderMovieModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<OrderMovieModel>() {
                @Override
                public OrderMovieModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new OrderMovieModel(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public int updateStatus(Integer orderId, Integer orderStatus, String date) {
        //Switch between status
        String query = "";
        switch (orderStatus){
            case 2:
                query = "update \"order\"\n" +
                        "set order_status = ?,\n" +
                        "prepared_order_date = ?\n" +
                        "where order_id = ?";
                break;
            case 3:
                query = "update \"order\"\n" +
                        "set order_status = ?,\n" +
                        "dispatched_order_date = ?\n" +
                        "where order_id = ?";
                break;
            case 4:
                query = "update \"order\"\n" +
                        "set order_status = ?,\n" +
                        "delivered_order_date = ?\n" +
                        "where order_id = ?";
                break;
        }
        try {
            return jdbcTemplate.update(query, orderStatus,date, orderId);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    public int updateCopies(Integer orderId, ArrayList<OrderMovieCopyModel> orderMovieCopyModels) {
        //Switch between status
        String query = "update order_movie\n" +
                "set prepared_quantity = ?\n" +
                "where order_id = ?\n" +
                "and movie_id = ?";

        for(int i = 0; i < orderMovieCopyModels.size(); i++) {
            try {
                jdbcTemplate.
                        update(query, orderMovieCopyModels.get(i).getPreparedQuantity(), orderId, orderMovieCopyModels.get(i).getMovieId());
            } catch (Exception ex) {
                throw new RuntimeException();
            }
        }
        return 1;
    }


}
