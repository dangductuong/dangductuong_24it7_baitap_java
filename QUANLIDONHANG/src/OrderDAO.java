import java.sql.*;
import java.util.*;

public class OrderDAO {
    private Connection conn;

    public OrderDAO(Connection conn) {
        this.conn = conn;
    }

    public void addOrder(Order order) throws SQLException {
        String insertOrderSQL = "INSERT INTO orders(customer_id, order_date) VALUES(?, ?)";
        String insertItemSQL = "INSERT INTO order_items(order_id, product_id, quantity) VALUES(?, ?, ?)";

        PreparedStatement orderStmt = conn.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
        orderStmt.setInt(1, order.getCustomerId());
        orderStmt.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
        orderStmt.executeUpdate();

        ResultSet keys = orderStmt.getGeneratedKeys();
        int orderId = 0;
        if (keys.next()) {
            orderId = keys.getInt(1);
        }

        for (OrderItem item : order.getOrderItems()) {
            PreparedStatement itemStmt = conn.prepareStatement(insertItemSQL);
            itemStmt.setInt(1, orderId);
            itemStmt.setInt(2, item.getProductId());
            itemStmt.setInt(3, item.getQuantity());
            itemStmt.executeUpdate();
        }
    }


    public List<Order> getOrdersByCustomerId(int customerId) throws SQLException {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE customer_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Order o = new Order();
            o.setId(rs.getInt("id"));
            o.setCustomerId(rs.getInt("customer_id"));
            o.setOrderDate(rs.getDate("order_date"));
            list.add(o);
        }

        return list;
    }

    public double calculateTotalAmount(int orderId) throws SQLException {
        String sql = """
            SELECT SUM(p.price * oi.quantity) AS total
            FROM order_items oi
            JOIN products p ON oi.product_id = p.id
            WHERE oi.order_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, orderId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getDouble("total");
        }
        return 0;
    }


}
