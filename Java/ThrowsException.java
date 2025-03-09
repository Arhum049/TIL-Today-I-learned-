public class ThrowsException {

    public static void checkNumber(int num) {
        if (num < 0) {
            // throw new ArithmeticException("Negative numbers are not allowed");
        }
        System.out.println("You have been successfully registered!");
    }

    public static void main(String[] args) {
        try {
            checkNumber(-5);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
