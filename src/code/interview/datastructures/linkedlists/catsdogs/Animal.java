package code.interview.datastructures.linkedlists.catsdogs;

public abstract class Animal {
	private int order;
	protected String name;

	public Animal(String n) {
		name = n;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public int getOrder() {
		return order;
	}

	public boolean isO1derThan(Animal a) {
		return this.order < a.getOrder();
	}
}
