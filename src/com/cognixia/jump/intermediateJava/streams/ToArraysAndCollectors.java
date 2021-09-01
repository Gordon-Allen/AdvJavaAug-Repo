package com.cognixia.jump.intermediateJava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

/**
 * Class Purpose - has main() -> specific demos of collections terminal operator on streams
 * Shows Collectors class and good demo to put into map with Groupinby
 * 
 * Can run through top to bottom at pace of choosing
 */

public class ToArraysAndCollectors {
	
	// need Employee.java prior to start
	public static void main(String[] args) {
		// make a collection  of dummy employee data
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
		
		
		// find all the database archs and put them in a seperate list
		Employee[] da = employees.stream()
						.filter( empl -> empl.getDepartment().equals("Database Arch") )
						.toArray(Employee[]::new);
		
		//Employee[] temp = new Employee[5];
		
		
		List<Employee> daList = (ArrayList<Employee>) employees.stream()
								.filter( empl -> empl.getDepartment().equals("Database Arch") )
								.collect(Collectors.toList());
		
		
		employees.stream()
		.filter( empl -> empl.getDepartment().equals("Database Arch") )
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		
		// filter list, get everyone who makes more than 200,000
		// filter list, get everyone who makes less than or equal to 200,000
		
		// true -> above 200k
		// false -> below 200k
		
		// Entry(key, value)
		
		Map<Boolean, List<Employee>> classDivide =
						employees.stream()
						.collect( Collectors.partitioningBy( empl -> empl.getSalary() > 200000 ) );
		
		//System.out.println(classDivide.get(false));
//		
//		Stream<Object> temp =
//		classDivide.entrySet()
//		.stream()
//		.filter( entry -> entry.getKey() == true )
//		.map( Map.Entry::getValue );
//		//.forEach(System.out::println);
		
		System.out.println("\n******");
		
		classDivide.get(false).forEach(System.out::println);
		
		
		 Map<String, List<Employee> > departments = employees.stream()
				 									.collect( Collectors.groupingBy( Employee::getDepartment ) );
		 
		 // print each department and their employees
		 
		 System.out.println("\nDEPARTMENTS:");
		 
		 departments.forEach( (k, v) -> {
			 System.out.println("\n" + k + ":");
			 v.forEach(System.out::println);
		 } );
		 
		
		// print departments and employee name and salary
		 
		 System.out.println("\n\nDEPARTMENTS:");
		 
		 departments.forEach( (k, v) -> {
			 System.out.println("\n" + k + ":");
			 v.forEach(ToArraysAndCollectors::printNameAndSalary);
		 } );
		 
		 
		 // print departments with employees who make above 200k
		 
		 System.out.println("\n\nDEPARTMENTS:");
		 
		 departments.forEach( (k, v) -> {
			 System.out.println("\n" + k + ":");
			 
			 v.stream()
			 .filter( e -> e.getSalary() > 200000 )
			 .forEach(ToArraysAndCollectors::printNameAndSalary);
		 } );
		
		
	}
	
	public static void printNameAndSalary(Employee e) {
		
		System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());
		
	}

}

