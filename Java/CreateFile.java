import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("Entries.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already existed");
            }
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }
}