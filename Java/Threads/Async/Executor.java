import java.util.concurrent.Callable;
import java.util.concurrent.*;

public class Executor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<String> future1 = executor.submit(new Task(1));
        Future<String> future2 = executor.submit(new Task(2));
        Future<String> future3 = executor.submit(new Task(3));

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (Exception e) {
            e.getStackTrace();
        }
        executor.shutdown();
    }
}

class Task implements Callable<String> {

    private int taskID;

    public Task(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Task " + taskID + " is starting");
        Thread.sleep(2000);
        return "Task " + taskID + " Completed";
    }

}