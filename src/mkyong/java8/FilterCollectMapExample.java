package mkyong.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import mkyong.java8.pojo.Person;

public class FilterCollectMapExample {

	private static void filterCollectExample() {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

		List<String> result = lines.stream()
								.filter(line -> !"mkyong".equals(line))
								.collect(Collectors.toList());

		result.forEach(System.out::println);
	}

	private static void filterFindAnyExample() {
		List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

		Person result1 = persons.stream()
								.filter(x -> "jack".equals(x.getName()))
								.findAny()
								.orElse(null);

		System.out.println(result1);

		Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);
	}

	private static void filterMapExample() {
		List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

		String name = persons.stream()
						.filter(x -> "jack".equals(x.getName()))
						.map(Person::getName)
						.findAny()
						.orElse("");

		System.out.println("name : " + name);

		List<String> collect =  persons.stream()
				.map(Person::getName)
				.collect(Collectors.toList());

		collect.forEach(System.out::println);
	}

	public static void main(String[] args) {
		filterCollectExample();
		filterFindAnyExample();
		filterMapExample();
	}
}
