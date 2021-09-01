package com.cognixia.jump.intermediateJava.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Purpose - has main() - also need Employee.java prior to this
 * 		shows use of parallel streams
 * 		Parallel stream creates threads that solve functions concurrently.  This MAY speed up calculations,
 * 		IF the matching has cores that can support adequately.  However, ORDER is NOT preserved, so if a collection
 * 		is order dependent, this will be lost through parallel streams
 * 
 * Walk through top to bottom at pace of your choosing.
 */

public class ParallelStreams {
	
	// Main method -> have Employee.java prior to starting
	public static void main(String[] args) {
		
		// Create collection of Employees and insert dummy data
		List<Employee> employees = new ArrayList<Employee>();
		
		for(int i = 0; i < 10000; i++) {
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
		}
		
		
		// Showing time performance using a sequential (regular stream) then will compare to parallel stream (further down)
		// filter and calculate processing time -> sequential 
		long before = System.currentTimeMillis();
		
		long count = employees.stream()
					.filter( e -> e.getSalary() > 500000 )
					.count();
		
		long after = System.currentTimeMillis();
		
		System.out.println("Sequential "
				+ "Stream count = " + count + " | Time = " + (after - before) );
		
		
		// filter and calculate processing time -> parallel 
		before = System.currentTimeMillis();
		
		count = employees.parallelStream()
				.filter( e -> e.getSalary() > 500000 )
				.count();
		
		after = System.currentTimeMillis();
		
		System.out.println("Parallel Count = " + count + " | Time = " + (after - before) );
		
	}

}
