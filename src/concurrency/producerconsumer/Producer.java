package concurrency.producerconsumer;

import java.util.LinkedList;

public class Producer implements Runnable {

	private final LinkedList<Integer> queue;
	private final int size;
	
	public Producer(LinkedList<Integer> queue, int size) {
		this.queue = queue;
		this.size = size;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Produced: " + i);

			try {
				produce(i);
			} catch (InterruptedException ie) {}
		}
	}

	private void produce(int i) throws InterruptedException {
		while (queue.size() == size) {
			synchronized (queue) {
				System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + queue.size());

				queue.wait();
			}
		}

		synchronized (queue) {
			queue.add(i);
			queue.notifyAll();
		}
	}
}
