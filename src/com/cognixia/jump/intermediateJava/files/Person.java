package com.cognixia.jump.intermediateJava.files;

import java.io.Serializable;

public class Person implements Serializable {


	// the serial ID is used to determine if an object that was written to a file is
	// the same version of the class as it is now when it attempts to read it
	// you should change this ID everytime you make changes to the class (add an email
	// field to Person), that way when you try to read an old version of the person object
	// this ID can tell you they aren't compatible because they are not the same version
	// of the class
	private static final long serialVersionUID = 731051550405653783L;

	private String name;
	private int age;

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
