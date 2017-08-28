package mkyong.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import mkyong.java8.pojo.Developer;

public class ComparatorsExample {

	private static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;
	}

	public static void main(String[] args) {
		List<Developer> listDevs = getDevelopers();	

		System.out.println("Before Sort");
		listDevs.forEach((developer) -> System.out.println(developer));

		System.out.println("Sort by age:");
		listDevs.sort((d1, d2) -> d1.getAge() - d2.getAge());
		listDevs.forEach((developer) -> System.out.println(developer));

		System.out.println("Sort by name:");
		listDevs.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));
		listDevs.forEach((developer) -> System.out.println(developer));
	
		System.out.println("Sort by salary:");
		listDevs.sort((d1, d2) -> d1.getSalary().compareTo(d2.getSalary()));
		listDevs.forEach((developer) -> System.out.println(developer));
	}
}
