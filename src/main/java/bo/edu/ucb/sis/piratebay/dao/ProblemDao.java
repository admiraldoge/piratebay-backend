package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.ProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
            return jdbcTemplate.update(queryToAssociate,orderId, problemId);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
