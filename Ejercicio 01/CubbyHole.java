public class CubbyHole {
    private int contents;
    private boolean available = false;

    public CubbyHole() {
    }
    
    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}