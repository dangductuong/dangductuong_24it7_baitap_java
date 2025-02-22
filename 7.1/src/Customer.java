public class Customer {
    private String name;
    private String membership;

    public Customer(String name, String membership) {
        this.name = name;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}
