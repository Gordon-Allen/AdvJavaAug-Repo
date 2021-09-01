package com.cognixia.jump.intermediateJava.streams;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Purpose - has main() -> specific demos of .reduce() method, have Employee.java prior to start.
 * 		.reduce() -> can take in text or numeric data, aggregates to a single result such as sum or
 * 		concatenated String
 * 
 * Can run through top to bottom at pace of choosing
 */

public class ReduceStreams {
	
	// main method -> requires Employee.java prior to start
	public static void main(String[] args) {
		
		// use .reduce() to caculate a sum from a collection
		List<Integer> numbers = Arrays.asList(2, 4, 6, 6, 2, 4, 12, 3, 11);
		
		// sum of the numbers
		int sum = numbers.stream()
					.reduce((num1, num2) -> num1 + num2 )
					.get();
		
		System.out.println("sum = " + sum);
		
		// find the largest value in numbers
		int biggest = numbers.stream()
						.reduce( (num1, num2) -> num1 > num2 ? num1 : num2 )
						.get();
		
		System.out.println("biggest = " + biggest);
		
		// Make a collection of employees and insert dummy data
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
		employees.add(new Employee("Kyle", Integer.MIN_VALUE, "CEO"));
		
		
		// find the lowest salary in an employee
		Employee lowestSalary = employees.stream()
								.reduce( (e1, e2) -> e1.getSalary() < e2.getSalary() ? e1 : e2 )
								.get();
		
		System.out.println(lowestSalary);
		
		
		// combine strings
		String[] alphabet = { "abc", "de", "fghi", "jklmno" };
		
		String combined = Arrays.stream(alphabet)
							.reduce( (str1, str2) -> str1 + str2 )
							.get();
		
		System.out.println("combined string is " + combined);
		
		
		// get all the departments from employees using reduce and print a string in this format:
		// str = dept1, dept2, dept3...
		//  Developer, Engineer, FrontEnd...
		
		
		
		String allDepartments = employees.stream()
								.map(Employee::getDepartment)
								.distinct()
								.reduce((dept1, dept2) -> dept1 + ", " + dept2 )
								.get();
		
		System.out.println(allDepartments);
		
		
		
		
		allDepartments = employees.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment))
						.keySet()
						.stream()
						.reduce((dept1, dept2) -> dept1 + ", " + dept2)
						.get();
		
		System.out.println(allDepartments);
		
	}

}