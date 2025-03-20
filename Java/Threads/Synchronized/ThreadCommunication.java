class SharedResources {
    private int data;
    private boolean hasData;

    public synchronized void consume() {
        while (!hasData) {
            try {
                wait();

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
    }

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();

    }
}

class Consumer implements Runnable {
    private SharedResources resources;

    public Consumer(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            resources.consume();
        }
    }

}

class Producer implements Runnable {
    private SharedResources resources;

    public Producer(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            resources.produce(i);
        }
    }

}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResources resources = new SharedResources();
        Thread producerThread = new Thread(new Producer(resources));
        Thread consumerThread = new Thread(new Consumer(resources));
        producerThread.start();
        consumerThread.start();
    }

}