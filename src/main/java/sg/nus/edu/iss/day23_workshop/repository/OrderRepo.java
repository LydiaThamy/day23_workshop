package sg.nus.edu.iss.day23_workshop.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.day23_workshop.exception.OrderNotFoundException;
import sg.nus.edu.iss.day23_workshop.model.Order;

@Repository
public class OrderRepo {

    @Autowired
    private JdbcTemplate template;

    final static Logger LOGGER = LoggerFactory.getLogger(OrderRepo.class);

    private final String getSql = """
            SELECT o.id AS order_id, o.order_date, o.customer_id,
                SUM(od.quantity*od.unit_price*(1-od.discount)) as total,
                SUM(p.standard_cost*od.quantity) as cost_price
            FROM orders AS o
            JOIN (
                order_details AS od
                JOIN products AS p
                ON od.product_id = p.id)
            ON o.id = od.order_id
            WHERE order_id = ?;
            """;

    public Order getOrder(Integer orderId) {
        Order order = template.queryForObject(getSql, BeanPropertyRowMapper.newInstance(Order.class), orderId);

        if (order.getOrderId() == null)
            throw new OrderNotFoundException("Order ID " + orderId + " not found");

        return template.queryForObject(getSql, BeanPropertyRowMapper.newInstance(Order.class), orderId);
    }
}
