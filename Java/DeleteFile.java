import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("Entries.txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(file.getName() + " deleted successfully");
            } else {
                System.out.println("Failed to delete file");
            }
        } else {
            System.out.println("File doesnot Exist");
        }
    }
}
