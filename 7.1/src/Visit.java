public class Visit {
    private Customer customer;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer) {
        this.customer = customer;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = serviceExpense * DiscountRate.getServiceDiscountRate(customer.getMembership());
        double productDiscount = productExpense * DiscountRate.getProductDiscountRate();
        return (serviceExpense - serviceDiscount) + (productExpense - productDiscount);
    }
}
