package programming.interviews.exposed.concurrency.threads;

public class Threads {

	public static void main(String[] args) {
		final Thread separateThread = new Thread(new ThreadPrinter());

		separateThread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("From the new thread: " + Thread.currentThread().getName());

			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
}
