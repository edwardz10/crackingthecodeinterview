package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	private static final CountDownLatch START = new CountDownLatch(8);

	private static final int trackLength = 500000;

	private static class Car implements Runnable {

		private int carNumber;
		private int carSpeed;

		public Car(int carNumber, int carSpeed) {
			this.carNumber = carNumber;
			this.carSpeed = carSpeed;
		}
		
		@Override
		public void run() {
			try {
				System.out.printf("Car %d has reached the starting point\n", carNumber);
				START.countDown();
				START.await();
				Thread.sleep(trackLength / carSpeed);
				System.out.printf("Car %d has finished the race\n", carNumber);
			} catch (InterruptedException ie) {}
			
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }

        while (START.getCount() > 3) //Проверяем, собрались ли все автомобили
            Thread.sleep(100);              //у стартовой прямой. Если нет, ждем 100ms

        Thread.sleep(1000);
        System.out.println("На старт!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Марш!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1	
	}
}
