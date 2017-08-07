package code.interview.datastructures.linkedlists;

public class FindNthToLastElement {
	
	public static int getNthToLastElement(MyLinkedList l, int n) {
		int size = l.size();

		if (size <= n) {
			System.out.println("List's length is less or equal to N: " + size + " <= " + n);
			return -1;
		}

		Node begin, end;
		begin = end = l.head;

		for (int i = 0; i < n; i++) {
			end = end.next;
		}
		
		while (end != null) {
			begin = begin.next;
			end = end.next;
		}

		return begin.data;
	}
	
	
	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 3, 2, 1, 5, 44, 4, 55, 2, 52, 55};
		
		MyLinkedList l = new MyLinkedList(values);
		int n = 10;

		int nThToLastElement = getNthToLastElement(l, n);
		
		System.out.println(n + " element to last in the list is " + nThToLastElement);
	}
}
