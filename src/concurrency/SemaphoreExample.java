package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	private static final boolean[] PARKING_PLACES = new boolean[5];
	private static final Semaphore SEMAPHORE = new Semaphore(5, true);

	private static class Car implements Runnable {

		private int carNumber;

		public Car(int carNumber) {
			this.carNumber = carNumber;
		}
		
		@Override
		public void run() {
			System.out.println("The car " + carNumber + " has entered the parking lot");

			try {
				SEMAPHORE.acquire();
				int parkingNumber = -1;

				synchronized (PARKING_PLACES) {
					for (int i = 0; i < 5; i++) {
						if (!PARKING_PLACES[i]) {
							PARKING_PLACES[i] = true;
							parkingNumber = i;
							System.out.println("The car " + carNumber + " has parked on place " + i);
							break;
						}
					}
				}

				Thread.sleep(5000L);

				synchronized (PARKING_PLACES) {
					PARKING_PLACES[parkingNumber] = false;					
				}

				SEMAPHORE.release();
				System.out.println("The car " + carNumber + " has left the parking lot");
			} catch (InterruptedException ie) {
				
			}
			
			
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <= 7; i++) {
			new Thread(new Car(i)).start();
			Thread.sleep(400);
		}
	}
}
