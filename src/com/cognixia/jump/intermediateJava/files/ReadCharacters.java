package com.cognixia.jump.intermediateJava.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCharacters {

	public static void main(String[] args) {
		
		File file = new File("resources/letters.txt");
		FileReader fileReader = null;
		BufferedReader reader = null;
		
		
		try {
			
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			
			int charValue;
			
			while(     (charValue = reader.read()) != -1       ) {
				
				char letter = (char) charValue;
				
				if (letter == 'x') {
					System.out.println("*** REACHED 'x' ***");
					break;
				}
				
				System.out.println("<== READ --> " + (char) charValue + " ==>");
				
			}
			
			reader.skip(5);
			System.out.println("6th character  from 'x' ==> " + (char) reader.read());
			
			
			
		} catch(FileNotFoundException e) {
			System.out.println("EXCEPTION: Could not find file: " + file.getAbsolutePath());
		} catch(IOException e) {
			System.out.println("EXCEPTION: Could not read character!!");
		} finally {
			
			try {
				fileReader.close();
				reader.close();
			} catch (IOException e) {
				System.out.println("EXCEPTION: Could not close file!!!");
			}
			
			
			
		}

	}

}
