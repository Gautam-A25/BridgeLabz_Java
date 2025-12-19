public class FeeDiscount {
    public static void main(String[] args) {
        double originalFee = 125000;
        double discountPercentage = 10;
        double discountAmount = (discountPercentage / 100) * originalFee;
        double discountedFee = originalFee - discountAmount;
        System.out.println("The discounted amount is: " + discountAmount);
        System.out.println("The fee after a discount of " + discountPercentage + "% is: " + discountedFee);
    }
}
