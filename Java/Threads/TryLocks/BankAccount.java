import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withDraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " -attempting to withdraw");
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " -proceeding with withdrawl");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " -Successfully completed withdrawl-remaining balance: $" + balance);

                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " -Insufficient Balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " -Could not acquire lock");
            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

}
