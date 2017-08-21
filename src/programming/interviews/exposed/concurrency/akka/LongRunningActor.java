package programming.interviews.exposed.concurrency.akka;

import akka.actor.UntypedActor;

public class LongRunningActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		System.out.printf("Being run on ActorRef: %s%n", getSelf());

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Received %s%n", message);
	}

}
