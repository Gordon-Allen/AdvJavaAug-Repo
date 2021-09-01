package com.cognixia.jump.intermediateJava.functionalinterface;

import java.util.Scanner;

@FunctionalInterface
interface Calculation {
	
	float calculate(int x, int y);
}

public class Calculator {
	
	static Calculation add = (x, y) -> x + y;
	static Calculation sub = (x, y) -> x - y;
	static Calculation mul = (x, y) -> x * y;
	static Calculation div = (x, y) -> x / y;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int y = 0;
		char operation = 0;
		
		System.out.println("Enter the first number");
		while (true) {
			try {
				x = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter an integer");
			}
		}
		
		while (true) {
			System.out.println("Enter the second number:");
			try {
				y = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter an integer:");
			}
		}
		
		while(true) {
			System.out.println("Enter the operation:");
			try {
				operation = scan.next().charAt(0);
				break;
			} catch (Exception e) {
				System.out.println("Please enter an integer");
			}
		}
			
		try {
//			System.out.println(classicCalcualtor(x, y, operation));
			System.out.println(functionalCalculator(x, y, operation));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		scan.close();
	}
	
	public static float classicCalcualtor(int x, int y, char operation) throws Exception {
		
		switch (operation) {
		
		case '+':
			return x + y;
		case '-':
			return x - y;
		case '*':
			return x * y;
		case '/':
			return x / y;
		default:
			throw new Exception("Operation not supported");
		
		}
		
	}
	
	public static float functionalCalculator(int x, int y, char operation) throws Exception {
		switch (operation) {
		
		case '+':
			return add.calculate(x, y);
		case '-':
			return sub.calculate(x, y);
		case '*':
			return mul.calculate(x, y);
		case '/':
			return div.calculate(x, y);
		default:
			throw new Exception("Operation not supported");
		
		}

	}

}

