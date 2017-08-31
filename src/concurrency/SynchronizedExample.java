package concurrency;

public class SynchronizedExample {

	private static class Counter {
		long count = 0;

		public synchronized void add(long value) {
			count += value;
		}
	}

	private static class CounterRunnable implements Runnable {

		protected Counter counter = null;

		public CounterRunnable(Counter counter) {
			this.counter = counter;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				counter.add(i);
			}
		}
		
	}

	public static void main(String[] args) {
		Counter counter = new Counter();

		Thread threadA = new Thread(new CounterRunnable(counter));
		Thread threadB = new Thread(new CounterRunnable(counter));

		threadA.start();
		threadB.start();

		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException ie) {}
	}
}
