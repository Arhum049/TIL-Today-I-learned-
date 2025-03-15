public class GPTsThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println("Before Start: " + t1.getState());

        t1.start();
        System.out.println("After Start: " + t1.getState());

        t1.join(); // Ensures main thread waits for t1 to finish

        System.out.println("Final State: " + t1.getState()); // Always TERMINATED
    }
}
