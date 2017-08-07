package code.interview.datastructures.linkedlists;

public class DeleteMiddleNode {
	public static void deleteMiddleNode(MyLinkedList list, Node node) {
		Node r = list.head;
		
		while (r.next != node && r != null) {
			r = r.next;
		}
		
		if (r == null) {
			System.out.println("For some reason the node wasn't found...");
			return;
		}
		
		r.next = node.next;
	}
	
	public static void main(String[] args) {
		int[] values = {1, 21, 33, 4, 3, 2, 1, 5, 44, 4, 55, 2, 52, 55};
		MyLinkedList l = new MyLinkedList(values);
		Node node = l.head;

		for (int i = 0; i < l.size()/2; i++, node=node.next);
		
		l.print();
		deleteMiddleNode(l, node);
		l.print();
	}
}
