public class Mytask implements Runnable {
    private int taskID;

    public Mytask(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskID + " is running on " + Thread.currentThread().getName());
        // try {
        // Thread.sleep(2000);
        // } catch (Exception e) {
        // e.getStackTrace();
        // }

        System.out.println("Completed " + taskID);
    }

}
