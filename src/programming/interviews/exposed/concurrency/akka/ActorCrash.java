
package programming.interviews.exposed.concurrency.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class ActorCrash extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		System.out.printf("Received result: [%s]%n", message);
	}

	public static void main(String[] args) {
		final ActorSystem system = ActorSystem.create("actorSystem");
		final ActorRef crashRef =
				system.actorOf(Props.create(ActorCrash.class));
		final ActorRef dividingActorRef =
				system.actorOf(Props.create(DividingActor.class));

		dividingActorRef.tell(5, crashRef);
		dividingActorRef.tell(0, crashRef);
		dividingActorRef.tell(1, crashRef);
	}
}
