package com.cognixia.jump.intermediateJava.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Purpose - Demo Method References.  Has main() and static fields 
 * 		(can demo only with this file) 		
 * 
 * Make the static attributes, and methods
 * 
 * Lines 58 + show the method reference calls
 */

public class MethodReference {
	
	// create some static fields for use in our example
	private static int count = 1;
	
	private int count2 = 1;
	
	// the methods will be called by method reference 
	public static void printCount(String str) {
		System.out.println(count + ". " + str);
		count++;		
	}
	
	public void nonStaticPrint(String str) {
		System.out.println(count2 + "- " + str );
		count2++;
	}
	
	// start main() to show outputs
	public static void main(String[] args) {
		
		List<String> colors = new ArrayList<String>();
		colors.add("red");
		colors.add("blue");
		colors.add("green");
		colors.add("yellow");
		
		// what we know to be the shortest way to print a list
//		for(String c : colors) {
//			System.out.println(c);
//		}
		
		// forEach -> takes in a method as a parameter to perform
		// 			  that action on it
		
		// forEach takes in a method reference as a parameter
		// method reference uses the ::
		// method reference is a pointer to a method
		//colors.forEach(System.out::println);
		
		//Note: method references should only use methods with one
		//		parameter
		
		
		// static (class) methods
		colors.forEach(MethodReference::printCount);
		
		
		// non-static (instance) method
		MethodReference mf = new MethodReference();
		
		// Print with method reference
		colors.forEach(mf::nonStaticPrint);
		
	}
	
	
	

}

