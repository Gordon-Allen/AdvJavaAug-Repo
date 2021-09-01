package com.cognixia.jump.intermediateJava.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		
		File file = new File("resources/tea.txt");
		FileReader fileReader = null;
		BufferedReader reader = null;
		
		try {
			
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);			
			
			
			System.out.println("<== CONTENTS OF 'tea.txt ==>\n");
			System.out.println("----------------------------------");
			
			String line;
			
			while(      (    line = reader.readLine()     )      != null         ) {
				System.out.println(line);
			}
			
			
			
			
			
		} catch(FileNotFoundException e) {
			System.out.println("EXCEPTION: Could not find file: " + file.getAbsolutePath());
		} catch(IOException e) {
			System.out.println("EXCEPTION: Could not read character!!");
		} finally {
			
			try {
				fileReader.close();
				reader.close();
			} catch (IOException e) {
				System.out.println("Could not close reader objects :(");
			}
		}
		
		
		

	}

}
