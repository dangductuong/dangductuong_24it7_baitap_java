//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", "Premium");
        Visit visit1 = new Visit(customer1);
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);
        System.out.println("Total Expense for " + customer1.getName() + " (Premium): $" + visit1.getTotalExpense());

        Customer customer2 = new Customer("Bob", "Gold");
        Visit visit2 = new Visit(customer2);
        visit2.setServiceExpense(200);
        visit2.setProductExpense(100);
        System.out.println("Total Expense for " + customer2.getName() + " (Gold): $" + visit2.getTotalExpense());

        Customer customer3 = new Customer("Charlie", "Silver");
        Visit visit3 = new Visit(customer3);
        visit3.setServiceExpense(150);
        visit3.setProductExpense(75);
        System.out.println("Total Expense for " + customer3.getName() + " (Silver): $" + visit3.getTotalExpense());

        Customer customer4 = new Customer("David", "None");
        Visit visit4 = new Visit(customer4);
        visit4.setServiceExpense(100);
        visit4.setProductExpense(50);
        System.out.println("Total Expense for " + customer4.getName() + " (No Membership): $" + visit4.getTotalExpense());
    }
}