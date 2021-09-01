package com.cognixia.jump.intermediateJava.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {

	public static void main(String[] args) {
		File file = null;
		FileWriter fileWriter = null;
		BufferedWriter buffWriter = null;
		PrintWriter printWriter = null;
		
		
		
		try {
			
			file = new File("resources/hello.txt");
			fileWriter = new FileWriter(file);
			buffWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(buffWriter);
			
			writeToFile(buffWriter, "Hello");
			System.out.println("SUCCESS: 'writeToFile()'");
			
			appendToFile(buffWriter, "HI");
			System.out.println("SUCCESS: 'appendToFile()'");
			
			writeUsingPrintWriter(printWriter, "Hello World");
			System.out.println("SUCCESS: writeUsingPrintWriter()'");
			
			

			
		} catch(IOException e) {
			System.out.println("EXCEPTION: 'IOEXCEPTION caught :(");
			e.printStackTrace();
		} finally {
			
			
			if(buffWriter != null) {
				try {
					buffWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(printWriter != null) {
				printWriter.close();
			}
			
			
			
			
		}

	}
	
	
	public static void writeToFile(BufferedWriter writer, String str) throws IOException{

		for(int idx = 0; idx < 3; idx++) {
			writer.write(str);
		}

	}
	
	public static void appendToFile(BufferedWriter writer, String str) throws IOException{

		for(int idx = 0; idx < 3; idx++) {
			writer.append(str);
		}

	}
	
	public static void writeUsingPrintWriter(PrintWriter printer, String str) {
		
		printer.println(str);
		printer.println();
		printer.println(str);
		printer.println(str);
		
		
	}
	
	
	

}
