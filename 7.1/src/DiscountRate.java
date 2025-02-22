public class DiscountRate {
    private static final double SERVICE_DISCOUNT_PREMIUM = 0.20;
    private static final double SERVICE_DISCOUNT_GOLD = 0.15;
    private static final double SERVICE_DISCOUNT_SILVER = 0.10;
    private static final double PRODUCT_DISCOUNT = 0.10;

    public static double getServiceDiscountRate(String membershipType) {
        switch (membershipType.toLowerCase()) {
            case "premium": return SERVICE_DISCOUNT_PREMIUM;
            case "gold": return SERVICE_DISCOUNT_GOLD;
            case "silver": return SERVICE_DISCOUNT_SILVER;
            default: return 0.0;
        }
    }

    public static double getProductDiscountRate() {
        return PRODUCT_DISCOUNT;
    }
}
