package com.cognixia.jump.intermediateJava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;


public class StreamAerobicsDriver {
	//MAIN
	public static void main(String[] args) {
		/*SECTION 1*/
		
		// Use Stream to convert an array of primitive ints to Integers array
		int[] primitive = {2, 4, 6, 6, 2, 4, 12, 3, 11};
		
		// Stream converts ints to Integers using .boxed() then method reference constructor
		Integer[] integers = Arrays.stream(primitive)
				.boxed()
				.toArray(Integer[]::new);
		
		// First Stream example is with Integer, use list below as data set.
		List<Integer> numbers = Arrays.asList(integers);
		
		// Print all using .forEach() and method Reference
		System.out.println("Our numbers using for Each:");
		numbers.forEach(System.out::println);

		// Sum of numbers (above) using Stream reduce
		int sum = numbers.stream()
				.reduce(0, (num1, num2) -> num1 + num2);
		
		// Print output
		System.out.println("\nsum = " + sum);

		// Find the largest value using Stream reduce
		int biggest = numbers.stream()
				.reduce((num1, num2) -> num1 > num2 ? num1 : num2)
				.get();

		// Print output
		System.out.println("biggest = " + biggest);
		
		// Get Average Integer from Collection using parallel Stream
		double avgInt = Stream.of(2, 4, 8, 16, 32, 64, 128).parallel()
				.mapToInt(Integer::new)
				.average()
				.getAsDouble();
		
		// Print Average
		System.out.println("\nAverage of ints is: " + String.format("%.2f",avgInt) + "\n");

		/*SECTION 2*/
		
		// Make our data set for Employees list, and add sample data
		List<Employee> employees = new ArrayList<Employee>();

		// Add sample data
		employees.add(new Employee("Josiah", 90000, "Engineer"));
		employees.add(new Employee("Matt", 100000, "Engineer"));
		employees.add(new Employee("Abe", 250000, "Engineer"));
		employees.add(new Employee("Terry", 250001, "Database Arch"));
		employees.add(new Employee("Roy", 2500000, "CEO"));
		employees.add(new Employee("Brian", 70000, "Dev"));
		employees.add(new Employee("Danny", Integer.MAX_VALUE, "Juggling"));
		employees.add(new Employee("Dan", 3000000, "Management"));
		employees.add(new Employee("Lee", 0, "Intern"));
		employees.add(new Employee("Terri", 350000, "Dev"));
		employees.add(new Employee("Stanley", 75000, "Dev"));
		employees.add(new Employee("Donny", 85000, "Mobile Eng"));
		employees.add(new Employee("Rebecca", 650000, "Finances"));

		// Assignment for class: find the employee with the lowest salary
		Employee poor = employees.stream()
				.reduce((e1, e2) -> e1.getSalary() < e2.getSalary() ? e1 : e2)
				.get();

		// Print output
		System.out.println("Poorest Employee is: " + poor.toString());
		
		// Optional Example with find first
		Optional<Employee> tom = employees.stream()
				.filter(e -> e.getName().equals("Tom"))
				.findFirst();

		// Print if we found Tom
		System.out.println("\nThe status of Tom is: " + tom.isPresent());
		// ASSIGNMENT for class: get all the departments from employees using reduce in this
		// format: dept1, dept2, dep3....

		// allDepartments = Engineer, Dev, CEO....

		// Solution 1 - using Collectors.groupingBy and keyset
		String allDepartments = employees.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment)).keySet()
							.stream()
							.reduce((e1, e2) -> (e1 + "] | [" + e2)).get();

		// Print output Solution 1
		System.out.println("\nAll the uniqued departments:\n"+ allDepartments);
		
		// Assignment: Print 2 Poorest Employees using Comparator
		System.out.println("\n2 poorest Employees:");
		employees.stream()
			.sorted(Comparator.comparing(Employee::getSalary))
			.limit(2)
			.forEach(System.out::println);

		// Print 2 Richest Employees using Comparator.reversed()
		System.out.println("\nRichest 2 Employees");
		employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.limit(2)
				.forEach(System.out::println);
		
		// Parallel Streams and DropWhile() this will drop all that don't meet the predicate
		// until the predicate is met, then it stops.  So if salary is < 100000 and a previous
		// salary in the pipeline was 100000 or higher, then it still remains.
		List<Employee> firstUnder6Gone = employees.parallelStream()
				.dropWhile(e -> e.getSalary() < 100000)
				.collect(Collectors.toList());
		System.out.println("\nFirst Employees under 6 figs gone: " + firstUnder6Gone);
		
		// Get Average salary using parallel streams, and we convert to DoubleStream to save code
		// from having to write out computing an average
		double avgSalary = employees.parallelStream()
				.mapToDouble(Employee::getSalary)
				.average()
				.getAsDouble();
		// Print Average Salary
		System.out.println("\nAverage salary: " + String.format("%.2f", avgSalary));
		
	}
}
