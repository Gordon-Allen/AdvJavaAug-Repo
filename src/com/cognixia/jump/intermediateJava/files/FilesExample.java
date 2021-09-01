package com.cognixia.jump.intermediateJava.files;

import java.io.File;
import java.io.IOException;

public class FilesExample {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("resources/temp.txt");
		
		System.out.println("<== #1 Does 'files.txt' exist? --> " + file.exists());
		
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("<== SUCCESS: Created NEW file called 'temp.txt' :) ==>");
		}
		
		System.out.println("<== #2 Does 'files.txt' exist? --> " + file.exists());
		
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("File Name: " + file.getName());
		System.out.println("Last Modified: " + file.lastModified());
		
		
		File dir = new File("resources/dir1");
		
		boolean createdDir1 = dir.mkdir();
		
		if(createdDir1) {
			System.out.println("<== SUCCESS: Created new directory 'dir1' :) ==>");
		}
		else {
			System.out.println("<== FAILED: Did not create new directory 'dir1' :( ==>");
		}
		
		File dirs = new File("resources/dir2/dir3");
		
		boolean createdDirs = dirs.mkdirs();
		
		if(createdDirs) {
			System.out.println("<== SUCCESS: Created new directories 'dir2/dir3' :) ==>");
		}
		else {
			System.out.println("<== FAILED: Did not create new  directories 'dir2/dir3' :( ==>");
		}
		
		
	}

}
