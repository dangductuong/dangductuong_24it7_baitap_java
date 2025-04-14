import org.w3c.dom.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private File xmlFile = new File("books.xml");

    public Main() {
        frame = new JFrame("Quản lý Thư viện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        String[] columns = {"Mã sách", "Tên sách", "Tác giả", "Năm", "Ngày xuất bản", "Số trang", "Thể loại", "Giá"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        loadBooks();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Thêm");
        JButton editButton = new JButton("Sửa");
        JButton deleteButton = new JButton("Xóa");

        addButton.addActionListener(this::addBook);
        editButton.addActionListener(this::editBook);
        deleteButton.addActionListener(this::deleteBook);

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void loadBooks() {
        try {
            if (!xmlFile.exists()) return;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList bookList = doc.getElementsByTagName("book");

            for (int i = 0; i < bookList.getLength(); i++) {
                Element book = (Element) bookList.item(i);
                tableModel.addRow(new Object[] {
                        book.getAttribute("id"),
                        book.getElementsByTagName("title").item(0).getTextContent(),
                        book.getElementsByTagName("author").item(0).getTextContent(),
                        book.getElementsByTagName("year").item(0).getTextContent(),
                        book.getElementsByTagName("publisher").item(0).getTextContent(),
                        book.getElementsByTagName("pages").item(0).getTextContent(),
                        book.getElementsByTagName("genre").item(0).getTextContent(),
                        book.getElementsByTagName("price").item(0).getTextContent()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBook(ActionEvent e) {
        String id = JOptionPane.showInputDialog("Nhập mã sách:");
        String title = JOptionPane.showInputDialog("Nhập tên sách:");
        String author = JOptionPane.showInputDialog("Nhập tác giả:");
        String year = JOptionPane.showInputDialog("Nhập năm xuất bản:");
        String publisher = JOptionPane.showInputDialog("Nhập ngày xuất bản:");
        String pages = JOptionPane.showInputDialog("Nhập số trang:");
        String genre = JOptionPane.showInputDialog("Nhập thể loại:");
        String price = JOptionPane.showInputDialog("Nhập giá sách:");

        tableModel.addRow(new Object[]{id, title, author, year, publisher, pages, genre, price});
        saveBooks();
    }

    private void editBook(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn một cuốn sách để sửa.");
            return;
        }

        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập mã sách:", table.getValueAt(selectedRow, 0)), selectedRow, 0);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập tên sách:", table.getValueAt(selectedRow, 1)), selectedRow, 1);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập tác giả:", table.getValueAt(selectedRow, 2)), selectedRow, 2);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập năm xuất bản:", table.getValueAt(selectedRow, 3)), selectedRow, 3);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập ngày xuất bản:", table.getValueAt(selectedRow, 4)), selectedRow, 4);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập số trang:", table.getValueAt(selectedRow, 5)), selectedRow, 5);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập thể loại:", table.getValueAt(selectedRow, 6)), selectedRow, 6);
        tableModel.setValueAt(JOptionPane.showInputDialog("Nhập giá sách:", table.getValueAt(selectedRow, 7)), selectedRow, 7);

        saveBooks();
    }

    private void deleteBook(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn một cuốn sách để xóa.");
            return;
        }

        tableModel.removeRow(selectedRow);
        saveBooks();
    }

    private void saveBooks() {
        try (FileWriter writer = new FileWriter(xmlFile)) {
            writer.write("<library>\n");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                writer.write("  <book id='" + tableModel.getValueAt(i, 0) + "'>\n");
                writer.write("    <title>" + tableModel.getValueAt(i, 1) + "</title>\n");
                writer.write("    <author>" + tableModel.getValueAt(i, 2) + "</author>\n");
                writer.write("    <year>" + tableModel.getValueAt(i, 3) + "</year>\n");
                writer.write("    <publisher>" + tableModel.getValueAt(i, 4) + "</publisher>\n");
                writer.write("    <pages>" + tableModel.getValueAt(i, 5) + "</pages>\n");
                writer.write("    <genre>" + tableModel.getValueAt(i, 6) + "</genre>\n");
                writer.write("    <price>" + tableModel.getValueAt(i, 7) + "</price>\n");
                writer.write("  </book>\n");
            }
            writer.write("</library>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
