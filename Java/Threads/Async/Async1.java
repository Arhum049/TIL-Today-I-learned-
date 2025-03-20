import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Async1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executor.submit(new Mytask(i));

        }

        executor.shutdown();
    }
}
