package com.cognixia.jump.intermediateJava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Purpose - has main() + Employee.java (make sure it is created)
 * 		Class shows different intermediate stream operations such as reduce, filter, etc.
 * 
 * Run through top to bottom at desired pace to show different stream functionality.
 */

public class MoreStreamMethods {
	
	// Main method - be sure to have an Employee.java created first
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 26, 93, 4, 105, 6, 17, 8, 9);
		
		// limit -> returns first n elements
		
		System.out.println("first 4 numbers:");
		numbers.stream()
			   .limit(4)
			   .forEach(System.out::println);
		
		
		// skip -> starts the stream after the element n
		
		System.out.println("\nnumbers after the 4th element");
		numbers.stream()
			   .skip(4)
			   .forEach(System.out::println);
		
		
		// sorted -> sorts the stream based on some logic
		// ascending
		List<Integer> sortedNums = numbers.stream()
								   .sorted() // no parameter, sorts in ascending order
								   .collect(Collectors.toList());
		
		System.out.println("sorted = " + sortedNums);
		
		// descending
		List<Integer> sortedNumsDesc = numbers.stream()
				   .sorted(Comparator.reverseOrder()) 
				   .collect(Collectors.toList());
		
		System.out.println("desc order = " + sortedNumsDesc);
		
		// Using Comparator class -> sorts the list with odd nums first, then even nums
		List<Integer> temp = numbers.stream()
		   .sorted(Comparator.comparing(n -> n % 2 == 0)) 
		   .collect(Collectors.toList());
		
		System.out.println(temp);
		
		
		// Make an Employee Collection and add dummy data for using stream operations
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Orquidia", 100000, "Developer"));
		employees.add(new Employee("Charles", 100000, "Developer"));
		employees.add(new Employee("Ranika", 1000000, "Engineer"));
		employees.add(new Employee("Saniora", 200000, "Front End"));
		employees.add(new Employee("Jihun", 100001, "Database Arch"));
		employees.add(new Employee("Rich", 60000, "Management"));
		employees.add(new Employee("Keanu", 260000, "Database Arch"));
		employees.add(new Employee("Isabelle", 570000, "Secretary"));
		employees.add(new Employee("Spike", 20000, "Intern"));
		employees.add(new Employee("Dio", 100, "Database Arch"));
		employees.add(new Employee("Jason", Integer.MAX_VALUE, "Intern"));
		employees.add(new Employee("Demetri", 0, "Intern"));
		employees.add(new Employee("Kyle", -100000, "CEO"));
		
		// sort by employee salary
		System.out.println("\nEmployees sorted by salary: ");
		
		employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				//.limit(3)
				.forEach(System.out::println);
		
		// top 3 highest salary
		System.out.println("\nTop 3:"); //highest salary
		employees.stream()
			.sorted( (e1, e2) -> e2.getSalary() - e1.getSalary() )
			.limit(3)
			.forEach(System.out::println);
		
		// matching with streams
		
		
		// anyMatch -> is there any match for this, if so give a boolean
		
		boolean check = employees.stream()
						.anyMatch(e -> e.getDepartment().equals("Developer"));
		
		System.out.println("\nAre there developers? " + check);
		
		
		// allMatch -> criteria matches everything in stream
		
		check = employees.stream()
				.allMatch(e -> e.getSalary() > 0);
		
		System.out.println("\nAll employees making a wage? " + check);
		
		
		// noneMatch -> nothing matches this criteria
		
		check = employees.stream()
				.noneMatch(e -> e.getName().equals("Michael"));
		
		System.out.println("\nNo one named Michael? " + check);
	
		// FINISH
	
	}

}

