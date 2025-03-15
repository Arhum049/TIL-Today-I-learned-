public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Void run() executing");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println("Before Start: " + t1.getState());
        t1.start();
        System.out.println("After Start: " + t1.getState());
        // Thread.sleep(100);
        System.out.println("As 2: " + t1.getState());
        System.out.println("As 3: " + t1.getState());
        System.out.println("As 4: " + t1.getState());
        System.out.println("As 5: " + t1.getState());

        System.out.println("As 6: " + t1.getState());
    }
}
