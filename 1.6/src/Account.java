public class Account {
    private String id;
    private String name;
    private double balance=0;
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public int credit(int amount) {
        return (int) (balance = balance + amount);
    }
    public int debit(int amount) {
       return (int) (balance = balance - amount);
    }
    public int transferTo(int amount, Account another) {
       return (int) (balance = balance + amount);
    }
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nBalance: " + balance;
    }
}
