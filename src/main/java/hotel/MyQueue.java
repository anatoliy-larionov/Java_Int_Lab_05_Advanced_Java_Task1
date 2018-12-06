package hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class MyQueue {
    private static final int CAPACITY = 5;
    private static final int MAXIMUM_REQUESTS = 15;

    private List<Hotel> hotelList = new LinkedList<>();
    private int countRequests;
    private static Logger log = LoggerFactory.getLogger(MyQueue.class);

    public synchronized void addId(Hotel hotel) {
        while (hotelList.size() == CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (countRequests < MAXIMUM_REQUESTS) {
            countRequests++;
            hotel.setId(this.countRequests);
            hotelList.add(hotel);
            log.info("Отправлено: {}  вместимость: {}", hotel, hotelList.size());
            if (this.countRequests == MAXIMUM_REQUESTS) {
                log.info("Очередь закончена!!!");
            }
            notifyAll();
        }

    }

    public synchronized Hotel getId() {
        while (hotelList.isEmpty()) {
            if (countRequests == MAXIMUM_REQUESTS) {
                return null;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        Hotel hotel = hotelList.remove(0);
        log.info("Получено: {}  вместимость: {}", hotel, hotelList.size());
        notifyAll();
        return hotel;
    }

    public int getReceivedRequests() {
        return countRequests;
    }

    public int getMaxRequest() {
        return MAXIMUM_REQUESTS;
    }
}
