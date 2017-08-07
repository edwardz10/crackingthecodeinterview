package code.interview.datastructures.stacksqueues;

import code.interview.datastructures.linkedlists.Node;

public class Queue {
	Node first, last;

	void enqueue(int item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}

	Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}
}
