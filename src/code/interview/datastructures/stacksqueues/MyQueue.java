package code.interview.datastructures.stacksqueues;

import java.util.Stack;

public class MyQueue<T> {
	private Stack<T> stackNewest, stackOldest;

	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public void add(T value) {
		stackNewest.push(value);
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}

	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}

}
