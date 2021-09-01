package com.cognixia.jump.intermediateJava.streams;

//**
//* Class Purpose - utility class (no main method)
//* 		used to stream Employees and the attributes that describe an Employee object
//* 
//* Make the attributes, getters and setters, and override the .toString() method
//* 
//*/

public class Person {

	// attributes -> make getters and setters as well, and .toString()
	private String name;
	private int age;
	
	public Person() {
		this("N/A", -1);
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

