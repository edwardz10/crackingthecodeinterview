package programming.interviews.exposed.concurrency.sync;

import static org.junit.Assert.*;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicSharedState {

	@Test
	public void atomicSharedState() {
		final Executor executorService = Executors.newCachedThreadPool();
		final AtomicCounter c = new AtomicCounter();
		executorService.execute(new CounterSetter(c));

		final int value = c.getNumber().incrementAndGet();
		assertEquals(value, 1);
	}
	
	private static class CounterSetter implements Runnable {
		private final AtomicCounter counter;

		public CounterSetter(AtomicCounter counter) {
			this.counter = counter;
		}
		
		@Override
		public void run() {
			while (true) {
				counter.getNumber().set(0);
			}
			
		}
		
	}

	private static class AtomicCounter {
		private final AtomicInteger number = new AtomicInteger(0);

		public AtomicInteger getNumber() {
			return number;
		}

	}
}
