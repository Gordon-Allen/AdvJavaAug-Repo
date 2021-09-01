package com.cognixia.jump.intermediateJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Purpose - has main() -> small demo of not empty stream check with .filter()
 * 
 * Can run through top to bottom at pace of choosing
 * or pass out to class on their own for time, since it's a brief specific demo
 */

public class StreamNotEmpty {

	public static void main(String[] args) {
		
		List<String> food = Arrays.asList("grilled cheese", "pizza", " ",
				"sushi", "eggs", "", null, null, "cookies", null, "popcorn",
				"pasta", "tacos", "", null, "cake", "   ");
		
		System.out.println(food);
		
		
		// filter through all the strings that aren't empty
		List<String> foodNotEmpty = food.stream() // set stream
									.filter( f -> ( f != null && !f.isBlank() ) ) // filter for not empty and null
									.collect(Collectors.toList()); // return stream as list
		
		System.out.println(foodNotEmpty);
		List<Integer> numbers = Arrays.asList(2, 4, 6, 6, 2, 4, 12);
		
		List<Integer> numbersInRange = numbers.stream()
				.filter(n -> (n >= 0 && n < 11))
				.collect(Collectors.toList());
		System.out.println("Filtered numbers list is: " + numbersInRange);
		
		List<Person> people = Arrays.asList( new Person(), new Person("Orquidia", 23),
				new Person(), new Person("Jason", 28), new Person("Jihun", 10),
				new Person(), new Person("Ranika", 50), new Person(), 
				new Person("N/A", 100), new Person("Code", -5), new Person("N/A", -7));
		
		// filter so person's name is not n/a (default constructor)
		// filter so person does not have a negative age
		List<Person> realPeople = people.stream()
				.filter( p -> ( p.getAge() > 0 ) && !p.getName().equals("N/A") )
				//.filter( p -> !p.getName().equals("N/A") )
				.collect(Collectors.toList());
		
		realPeople.forEach(System.out::println);
		
 
	}

}

