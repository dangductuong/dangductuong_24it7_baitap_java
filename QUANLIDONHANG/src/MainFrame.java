import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JComboBox<Customer> cbCustomers;
    private JTable tblProducts;
    private JButton btnAddOrder, btnViewOrders;
    private JTextArea taOrders;
    private DefaultTableModel productTableModel;

    private Connection conn;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public MainFrame() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quanlidonhang",
                    "root",
                    ""
            );

            customerDAO = new CustomerDAO(conn);
            productDAO = new ProductDAO(conn);
            orderDAO = new OrderDAO(conn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
            System.exit(0);
        }

        setTitle("Quản lý đơn hàng");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        loadCustomers();
        loadProducts();
    }

    private void initUI() {
        cbCustomers = new JComboBox<>();
        btnAddOrder = new JButton("Thêm đơn hàng");
        btnViewOrders = new JButton("Xem lịch sử");
        taOrders = new JTextArea(10, 40);
        taOrders.setEditable(false);

        // Table sản phẩm (Checkbox + tên + giá + số lượng)
        String[] columnNames = {"Chọn", "Tên sản phẩm", "Giá", "Số lượng"};
        productTableModel = new DefaultTableModel(columnNames, 0) {
            public Class<?> getColumnClass(int column) {
                return switch (column) {
                    case 0 -> Boolean.class;
                    case 2 -> Double.class;
                    case 3 -> Integer.class;
                    default -> String.class;
                };
            }

            public boolean isCellEditable(int row, int col) {
                return col == 0 || col == 3;
            }
        };

        tblProducts = new JTable(productTableModel);
        JScrollPane spProducts = new JScrollPane(tblProducts);
        JScrollPane spOrders = new JScrollPane(taOrders);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Chọn khách hàng:"), BorderLayout.WEST);
        topPanel.add(cbCustomers, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAddOrder);
        buttonPanel.add(btnViewOrders);

        add(topPanel, BorderLayout.NORTH);
        add(spProducts, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(spOrders, BorderLayout.EAST);

        // Sự kiện
        btnAddOrder.addActionListener(e -> addOrder());
        btnViewOrders.addActionListener(e -> viewOrderHistory());
    }

    private void loadCustomers() {
        try {
            List<Customer> customers = customerDAO.getAllCustomers();
            cbCustomers.removeAllItems();
            for (Customer c : customers) {
                cbCustomers.addItem(c);
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    private void loadProducts() {
        try {
            List<Product> products = productDAO.getAllProducts();
            for (Product p : products) {
                productTableModel.addRow(new Object[]{false, p.getName(), p.getPrice(), 1});
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    private void addOrder() {
        try {
            Customer customer = (Customer) cbCustomers.getSelectedItem();
            if (customer == null) return;

            List<OrderItem> items = new ArrayList<>();
            List<Product> products = productDAO.getAllProducts();

            for (int i = 0; i < tblProducts.getRowCount(); i++) {
                boolean selected = (Boolean) tblProducts.getValueAt(i, 0);
                if (selected) {
                    int quantity = (Integer) tblProducts.getValueAt(i, 3);
                    int productId = products.get(i).getId();

                    OrderItem item = new OrderItem();
                    item.setProductId(productId);
                    item.setQuantity(quantity);
                    items.add(item);
                }
            }

            if (items.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!");
                return;
            }

            Order order = new Order();
            order.setCustomerId(customer.getId());
            order.setOrderDate(new java.util.Date());
            order.setOrderItems(items);

            orderDAO.addOrder(order);
            JOptionPane.showMessageDialog(this, "Đơn hàng đã được thêm!");
        } catch (Exception e) {
            showError(e);
        }
    }

    private void viewOrderHistory() {
        try {
            Customer customer = (Customer) cbCustomers.getSelectedItem();
            if (customer == null) return;

            List<Order> orders = orderDAO.getOrdersByCustomerId(customer.getId());
            taOrders.setText("");

            for (Order o : orders) {
                double total = orderDAO.calculateTotalAmount(o.getId());
                taOrders.append("Đơn #" + o.getId() + " - Ngày: " + o.getOrderDate() + " - Tổng: " + total + " VND\n");
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    private void showError(Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }


    private static class OrderManagementApp {
        public void setVisible(boolean b) {
        }
    }
}
