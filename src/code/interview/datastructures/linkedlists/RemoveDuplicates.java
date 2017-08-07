package code.interview.datastructures.linkedlists;

import java.util.ArrayList;
import java.util.Collection;

public class RemoveDuplicates {
	
	public static void removeDuplicates(MyLinkedList l) {
		Collection<Integer> duplicates = new ArrayList<Integer>();

		if (l.head == null || l.head.next == null) {
			return;
		}
		
		Node current = l.head;
		Node next = current.next;
		
		if (next.data == current.data) {
			current.next = null;
			return;
		}

		while (current != null) {
			if (!duplicates.contains(current.data)) {
				duplicates.add(current.data);
			}
			
			current = current.next;
		}

		l.clear();
		
		for (Integer i : duplicates) {
			l.append(i);
		}
	}

	public static void removeDuplicates2(MyLinkedList l) {
		if (l.head == null || l.head.next == null) {
			return;
		}
		
		Node current = l.head;
		Node next = current.next;
		
		if (next.data == current.data) {
			current.next = null;
			return;
		}

		Node r = null;
		
		while (next != null) {
			r = l.head;

			while (r != next) {
				if (r.data == next.data) {
					System.out.println(next.data + " is a duplicate");
				}
				r = r.next;
			}
			
			next = next.next;
		}
	}
	
	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 3, 2, 1, 5};
		
		MyLinkedList l = new MyLinkedList(values);
		l.print();
		removeDuplicates(l);
		l.print();
	}
}
