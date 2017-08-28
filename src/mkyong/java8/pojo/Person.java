package mkyong.java8.pojo;

public class Person {

	private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o;
			return (name.equals(p.name)) && (age == p.age);
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + 19*age;
	}

	@Override
	public String toString() {
		return "name: " + name
				+ ", age: " + age;
	}

}
