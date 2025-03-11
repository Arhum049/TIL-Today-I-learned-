import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Entries.txt");
            writer.write("Writing in a file ");
            writer.close();
            System.out.println("Successfully wrote in the file");
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
