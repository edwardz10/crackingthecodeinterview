package mkyong.java8.pojo;

import java.math.BigDecimal;

public class Developer {

	private String name;
	private BigDecimal salary;
	private Integer age;

	public Developer() {}
	
	public Developer(String name, BigDecimal salary, Integer age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Developer) {
			Developer d = (Developer) o;
			return (name.equals(d.name)) && (salary.equals(d.salary)) && (age == d.age);
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + salary.hashCode() + 19*age;
	}

	@Override
	public String toString() {
		return "name: " + name
				+ ", salary: " + salary
				+ ", age: " + age;
	}
}
