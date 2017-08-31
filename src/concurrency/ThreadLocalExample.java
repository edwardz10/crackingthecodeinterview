package concurrency;

public class ThreadLocalExample {

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		
		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 1000D));

			try {
				Thread.sleep(2000L);
			} catch (InterruptedException ie) {}

			System.out.println(threadLocal.get());
		}
		
	}

	public static void main(String[] args) {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread t1 = new Thread(sharedRunnableInstance);
		Thread t2 = new Thread(sharedRunnableInstance);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ie) {}
	}
}
