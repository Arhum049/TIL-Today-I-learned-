public class Main extends Thread {
    public static void main(final String[] args) {
        final BankAccount sbi = new BankAccount();
        final Runnable task = new Runnable() {

            @Override
            public void run() {
                sbi.withDraw(50);
            }

        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
