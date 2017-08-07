package code.interview.datastructures.linkedlists;

public class PervertedSum {

	public static int list2int(MyLinkedList l) {
		int result = 0;
		int i = 0;
		Node r = l.head;
		
		while (r != null) {
			result += r.data * Math.pow(10, i++);
			r = r.next;
		}
		
		return result;
	}

	public static MyLinkedList int2list(int i) {
		int length = (int)(Math.log10(i) + 1);
		int[] values = new int[length]; 
		
		int j = 0;
		while (i > 10) {
			values[j++] = i % 10;
			i /= 10;
		}

		values[j] = i;
		
		MyLinkedList result = new MyLinkedList();
		for (j = length - 1; j >= 0; j--) {
			result.append(values[j]);
		}
		
		
		return result;
	}
	
	public static MyLinkedList sum(MyLinkedList l1, MyLinkedList l2) {
		return null;
	}
	
	public static void main(String[] args) {
		int[] values1 = {7, 1, 6};
		int[] values2 = {5, 9, 2};
		MyLinkedList l1 = new MyLinkedList(values1);
		MyLinkedList l2 = new MyLinkedList(values2);
		
		int2list(list2int(l1) + list2int(l2)).print();
//		System.out.println(int2list(234));
	}
}
