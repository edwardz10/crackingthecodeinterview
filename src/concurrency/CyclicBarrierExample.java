package concurrency;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());

	private static class FerryBoat implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(500);
				System.out.println("The ferry has transported the cars!");
			} catch (InterruptedException ie) {
			}
		}
		
	}

	private static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Car %d has reached the ferry station.\n", carNumber);
                BARRIER.await();
                System.out.printf("Car %d goes on.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 9; i++) {
			new Thread(new Car(i)).start();
            Thread.sleep(400);
		}
	}
}
