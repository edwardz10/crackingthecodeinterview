package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {

	private static class Producer implements Runnable {

		private BlockingQueue<Integer> sharedQueue;
		
		public Producer(BlockingQueue<Integer> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				try {
					System.out.println("Produced: " + i);
					sharedQueue.put(i);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	private static class Consumer implements Runnable{

	    private final BlockingQueue<Integer> sharedQueue;

	    public Consumer (BlockingQueue<Integer> sharedQueue) {
	        this.sharedQueue = sharedQueue;
	    }
	  
	    @Override
	    public void run() {
	        while(true){
	            try {
	                System.out.println("Consumed: "+ sharedQueue.take());
	            } catch (InterruptedException ex) {
	            }
	        }
	    }
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();
		Producer p = new Producer(sharedQueue);
		Consumer c = new Consumer(sharedQueue);

		new Thread(p).start();
		new Thread(c).start();
	}
}
