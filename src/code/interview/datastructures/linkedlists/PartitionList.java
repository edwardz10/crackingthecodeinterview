package code.interview.datastructures.linkedlists;

public class PartitionList {

	public static void swap(Node first, Node second) {
		int tmp = first.data;
		first.data = second.data;
		second.data = tmp;
	}
	
	public static void partition(MyLinkedList list, int pivot) {
		Node first, second;
		boolean isSorted = false;
		
		while (true) {
			first = list.head;
			while (first.data <= pivot) { 
				first = first.next;
			}

			second = first;

			while (second.data > pivot && !isSorted) { 
				second = second.next;
				
				if (second == null) {
					isSorted = true;
					break;
				}
			}

			if (isSorted) {
				break;
			}

			System.out.println("First: " + first.data);
			System.out.println("Second: " + second.data);

			swap(first, second);
			list.print();
		}
		
	}
	
	public static void main(String[] args) {
		int[] values = {1, 21, 33, 4, 3, 2, 1, 5, 44, 4, 55, 2, 52, 55};
		MyLinkedList l = new MyLinkedList(values);

		l.print();
		partition(l, 5);
		l.print();
	}
}
