package concurrency;

public class ChickenVoice {

	static EggVoice mAnotherOpinion;
	
	private static class EggVoice extends Thread {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try{
					sleep(1000);
				} catch(InterruptedException e) {}
				
				System.out.println("Egg!");	
			}
		}
	}
	
	public static void main(String[] args) {
		mAnotherOpinion = new EggVoice();	//�������� ������
		System.out.println("Start the fight...");
		mAnotherOpinion.start();

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);		//���������������� ����� �� 1 �������
			} catch(InterruptedException e) {}
			
			System.out.println("Chicken!");
		}

		if (mAnotherOpinion.isAlive()) {
			try {
				mAnotherOpinion.join();
			} catch(InterruptedException e){}
			
			System.out.println("Egg has won!");
		} else	{
			System.out.println("Chicken has won!");
		}

		System.out.println("Finish!");	
	}
}
