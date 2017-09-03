package concurrency.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		
		Producer producer = new Producer(queue, 10);
		Consumer consumer = new Consumer(queue);

		new Thread(producer, "Producer").start();
		new Thread(consumer, "Consumer").start();
	} 
}
