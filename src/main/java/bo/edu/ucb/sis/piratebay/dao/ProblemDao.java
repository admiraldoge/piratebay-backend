package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.OrderMovieModel;
import bo.edu.ucb.sis.piratebay.model.OrderProblemModel;
import bo.edu.ucb.sis.piratebay.model.ProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class ProblemDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProblemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int updateProblem(Integer orderId, String problemDescription) {
        //Switch between status
        String query = "update \"order\"\n" +
                "set has_problem = true,\n" +
                "problem_description = ?\n" +
                "where order_id = ?";

        try {
            return jdbcTemplate.update(query, problemDescription, orderId);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    public int createProblem(Integer orderId,ProblemModel problemModel) {
        String auxQuery = "select op.order_id,op.problem_id, p.order_status, p.title, p.date, p.problem_description\n" +
                "from order_problem op\n" +
                "join problem p on op.problem_id = p.problem_id";
        List<OrderProblemModel> result = null;
        try {
            result = jdbcTemplate.query(auxQuery, new RowMapper<OrderProblemModel>() {
                @Override
                public OrderProblemModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new OrderProblemModel(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        //Switch between status
        String query = "insert into problem(title, problem_description,order_status,date) values\n" +
                "(?,?,?,?)";

        String queryToAssociate = "insert into order_problem(order_id,problem_id)\n" +
                "values(?,?)";

        try {
            Integer problemId =  jdbcTemplate.update(
                    query,
                    problemModel.getTitle(),
                    problemModel.getProblemDescription(),
                    problemModel.getOrderStatus(),
                    problemModel.getDate()
            );
            return jdbcTemplate.update(queryToAssociate,orderId, result.size()+2);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
