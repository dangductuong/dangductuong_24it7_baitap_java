//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer(101, "John Doe", 'm');
        System.out.println(c1);

        Account acc1 = new Account(1001, c1, 500.0);
        System.out.println(acc1);

        acc1.deposit(200.0);
        System.out.println("After deposit: " + acc1);

        acc1.withdraw(100.0);
        System.out.println("After withdrawal: " + acc1);

        acc1.withdraw(700.0);
    }
}