package hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Booker implements Runnable {
    private static final int TIME_SLEEP = 5000;
    private MyQueue myQueue;
    private static Logger log = LoggerFactory.getLogger(Booker.class);

    Booker(MyQueue myQueue) {
        this.myQueue = myQueue;
    }
    public void run() {
        Hotel hotel;
        while ((hotel = myQueue.getId()) != null) {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            log.info("Обработано: {} ", hotel);
        }
    }
}
