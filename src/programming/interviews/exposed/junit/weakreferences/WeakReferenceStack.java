package programming.interviews.exposed.junit.weakreferences;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceStack<E> {
	private final List<WeakReference<E>> stackReference;
	private int stackPointer = 0;

	public WeakReferenceStack() {
		stackReference = new ArrayList<>();
	}

	public void push(E element) {
		this.stackReference.add(stackPointer++, new WeakReference<>(element));
	}

	public E pop() {
		return this.stackReference.get(--stackPointer).get();
	}

	public E peek() {
		return this.stackReference.get(stackPointer - 1).get();
	}
}
