package programming.interviews.exposed.concurrency.sync;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class LockedSharedState {

	@Test
	public void lockedSharedState() {
		final ExecutorService executorService = Executors.newCachedThreadPool();
		final SimpleCounter c = new SimpleCounter();

		executorService.execute(new CounterSetter(c));

		synchronized (c) {
			c.setNumber(200);
			assertEquals(200, c.getNumber());
		}
	}

	private static class CounterSetter implements Runnable {
		private final SimpleCounter counter;

		public CounterSetter(SimpleCounter counter) {
			this.counter = counter;
		}
		
		@Override
		public void run() {
			while (true) {
				synchronized (counter) {
					counter.setNumber(100);
				}
			}
			
		}
		
	}

	private static class SimpleCounter {
		private int number = 0;

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

	}
}
