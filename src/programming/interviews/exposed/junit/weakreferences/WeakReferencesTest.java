package programming.interviews.exposed.junit.weakreferences;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class WeakReferencesTest {

	@Test
	public void weakReferenceStackManipulation() {
		final WeakReferenceStack<ValueContainer> stack = new WeakReferenceStack<>();
		final ValueContainer vcExpected = new ValueContainer("Value for the stack");
		stack.push(new ValueContainer("Value for the stack"));

		ValueContainer peekedValue = stack.peek();
		assertEquals(peekedValue, vcExpected);
		assertEquals(stack.peek(), vcExpected);

		peekedValue = null;
		System.gc();
		assertNull(stack.peek());
	}

	@Test
	public void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("Shutting down JVM at time: " + new Date());
			}
		});
	}
}
