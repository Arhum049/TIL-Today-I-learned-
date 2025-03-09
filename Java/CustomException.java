class InvalidAgeException extends ArithmeticException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age under 18 - Not allowed");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
