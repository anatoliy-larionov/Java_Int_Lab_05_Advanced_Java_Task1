package hotel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private MyQueue myQueue;
    private Hotel hotel;
    private Random random = new Random();

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (this.myQueue.getReceivedRequests() < myQueue.getMaxRequest()) {
            hotel = generateName();
            myQueue.addId(hotel);
        }
    }

    private Hotel generateName() {
        List<Hotel> hotelList = new LinkedList<>();
        hotelList.add(new Hotel("Star"));
        hotelList.add(new Hotel("Black"));
        hotelList.add(new Hotel("Gold"));
        hotelList.add(new Hotel("Yellow"));
        hotel = hotelList.get(random.nextInt(hotelList.size()));
        return hotel;
    }
}