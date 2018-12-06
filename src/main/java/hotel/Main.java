package hotel;

public class Main {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Producer(myQueue));
            thread.setName("Producer " + i);
            thread.start();
        }
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(new Booker(myQueue));
            thread.setName("Booker " + i);
            thread.start();
        }
    }
}
