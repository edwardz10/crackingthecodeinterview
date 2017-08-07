package code.interview.datastructures.linkedlists;

public class MyLinkedList {
	public Node head = null;

	public MyLinkedList() {
	}

	public MyLinkedList(int[] values) {
		Node r = null;
		
		for (int i = 0; i < values.length; i++) {
			if (i == 0) {
				head = new Node(values[0]);
				r = head;
			}
			
			else {
				Node newNode = new Node(values[i]);
				r.next = newNode;
				r = newNode;
			}
		}
	}

	public void append(int value) {
		Node r = head;
		
		if (r == null) {
			head = new Node(value);
		} else {
			while (r.next != null) {
				r = r.next;
			}

			r.next = new Node(value);
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("List is empty");
		}

		Node r = head;
		System.out.println("List:");
		
		do {
			System.out.print(r.data + "\t");
			r = r.next;
		} while (r != null);

		System.out.println("");
	}
	
	public void clear() {
		head = null;
	}

	public int size() {
		int size = 0;

		if (head == null) {
			return size;
		} else {
			Node r = head;
			
			do {
				size++;
				r = r.next;
			} while (r != null);
		}

		return size;
	}
}
