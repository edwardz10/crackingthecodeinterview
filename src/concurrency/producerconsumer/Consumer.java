package concurrency.producerconsumer;

import java.util.LinkedList;

public class Consumer implements Runnable {

	private final LinkedList<Integer> queue;

    public Consumer(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (queue.isEmpty()) {
            synchronized (queue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + queue.size());

                queue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (queue) {
            queue.notifyAll();
            return (Integer) queue.remove(0);
        }
    }
}
