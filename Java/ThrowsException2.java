
public class ThrowsException2 {
    public static void checkNumber() throws ArithmeticException {
        int arr1[] = { 2, 5, 7, 8, 4 };
        int arr2[] = { 2, 5, 0, 8, 4 };
        for (int i = 0; i < 5; i++) {
            System.out.println(arr1[i] / arr2[i]);
        }
    }

    public static void main(String[] args) {
        try {
            checkNumber();
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divide by Zero");
        }
    }
}
