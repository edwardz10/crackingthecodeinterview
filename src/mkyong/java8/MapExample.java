package mkyong.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

	public static void uppercase() {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		List<String> collect = alpha.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());

		collect.forEach(c -> System.out.println(c));

		List<Integer> num = Arrays.asList(1,2,3,4,5);
		List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(collect1); //[2, 4, 6, 8, 10]
	}
	
	public static void main(String[] args) {
		uppercase();
	}
}
