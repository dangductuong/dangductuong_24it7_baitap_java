public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("tuong","dang",1,10);
        System.out.println("first name: "+employee.getFirstName()+"\nlast name: "+employee.getLastName()+"\nsalary: "+employee.getSalary());
        System.out.println(employee.raiseSalary(10));
    }
}