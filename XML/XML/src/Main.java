import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "students.xml";

    public static void addStudent() throws Exception {
        File file = new File(FILE_NAME);
        Document doc;
        Element root;

        if (file.exists()) {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            root = doc.getDocumentElement();
        } else {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            root = doc.createElement("students");
            doc.appendChild(root);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        String age = scanner.nextLine();
        System.out.print("Nhập chuyên ngành: ");
        String major = scanner.nextLine();

        Element student = doc.createElement("student");
        student.setAttribute("id", id);

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        student.appendChild(nameElement);

        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(age));
        student.appendChild(ageElement);

        Element majorElement = doc.createElement("major");
        majorElement.appendChild(doc.createTextNode(major));
        student.appendChild(majorElement);

        root.appendChild(student);
        saveXML(doc);
        System.out.println("Thêm sinh viên thành công!");
    }

    public static void readStudents() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("File không tồn tại!");
            return;
        }
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        NodeList students = doc.getElementsByTagName("student");
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            System.out.println("ID: " + student.getAttribute("id"));
            System.out.println("Name: " + student.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Age: " + student.getElementsByTagName("age").item(0).getTextContent());
            System.out.println("Major: " + student.getElementsByTagName("major").item(0).getTextContent());
            System.out.println("-------------------");
        }
    }

    public static void deleteStudent() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("File không tồn tại!");
            return;
        }
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        NodeList students = doc.getElementsByTagName("student");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên cần xóa: ");
        String idToDelete = scanner.nextLine();

        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            if (student.getAttribute("id").equals(idToDelete)) {
                student.getParentNode().removeChild(student);
                saveXML(doc);
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên!");
    }

    public static void updateStudent() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("File không tồn tại!");
            return;
        }
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        NodeList students = doc.getElementsByTagName("student");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên cần cập nhật: ");
        String idToUpdate = scanner.nextLine();

        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            if (student.getAttribute("id").equals(idToUpdate)) {
                System.out.print("Nhập tên mới: ");
                student.getElementsByTagName("name").item(0).setTextContent(scanner.nextLine());
                System.out.print("Nhập tuổi mới: ");
                student.getElementsByTagName("age").item(0).setTextContent(scanner.nextLine());
                System.out.print("Nhập chuyên ngành mới: ");
                student.getElementsByTagName("major").item(0).setTextContent(scanner.nextLine());
                saveXML(doc);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên!");
    }

    private static void saveXML(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_NAME)));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Thêm sinh viên");
            System.out.println("2. Đọc danh sách sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Cập nhật thông tin sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addStudent(); break;
                case "2": readStudents(); break;
                case "3": deleteStudent(); break;
                case "4": updateStudent(); break;
                case "5": return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
