package code.interview.datastructures.catsdogs;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order++);

		if (a instanceof Dog) {
			dogs.add((Dog) a);
		} else if (a instanceof Cat) {
			cats.add((Cat) a);
		}
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		return dog.isO1derThan(cat) ? dequeueDogs() : dequeueCats();
	}

	private Dog dequeueDogs() {
		return dogs.poll();
	}

	private Cat dequeueCats() {
		return cats.poll();
	}
}