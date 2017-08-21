package programming.interviews.exposed.concurrency.akka;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.actor.SupervisorStrategy.Directive;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

public class DividingActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof Integer) {
			Integer number = (Integer) message;
			int result = 10 / number;
			this.getSender().tell(result, getSelf());
		}
	}

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return new OneForOneStrategy(
				10,
				Duration.Inf(),
				new Function<Throwable, SupervisorStrategy.Directive>() {
					
					@Override
					public Directive apply(Throwable arg0) throws Exception {
						return SupervisorStrategy.restart();
					}
				});
	}
}
