public class ErrorResolving {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;
        int[] arr = { 1, 2, 3 };

        try {
            double k = i / j;
            System.out.println(k);
        } catch (ArithmeticException e) {
            System.out.println("Exception: Cannot divide by zero");
        }
        try {
            System.out.println(arr[3]); // Array out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array out of bound ");
        }
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Exception: Null pointer");
        }
        try {
            String num = "abc";
            int value = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format");
        } finally {
            System.out.println("Final block executed");
        }

        System.out.println("Program finished successfully.");
    }
}
