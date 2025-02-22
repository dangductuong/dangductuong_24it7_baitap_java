//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", "123 Main St");
        System.out.println(person);

        Student student = new Student("Bob", "456 College Ave", "Computer Science", 2023, 15000.0);
        System.out.println(student);

        Staff staff = new Staff("Charlie", "789 High St", "XYZ School", 50000.0);
        System.out.println(staff);
    }
}