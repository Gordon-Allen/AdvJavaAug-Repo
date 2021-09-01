package com.cognixia.jump.intermediateJava.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamIO {

	public static void main(String[] args) {

		// create file
		File file = new File("resources/bytesfile.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// create two methods, one for writing bytes, the other for reading bytes		
		writeBytes(file, "Hello World\nThis is a new line");
		readBytes(file);
		
		// If anyone asks, a way to append something to a file using the byte stream is to
		// first read in the file, save the contents to a variable, then append what you need
		// to the variable you have. Then overwrite the file with the newly formated content.
		
	}

	// will overwrite anything already written in file
	public static void writeBytes(File file, String toWrite) {

		// this time use a try with resources
		// BufferedOutputStream takes in a FileOutputStream
		try ( BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file))  ) {

			writer.write(toWrite.getBytes());
			writer.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void readBytes(File file) {

		try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))) {

			// read everything
			System.out.println("file contents: ");
			
			int byt = reader.read();
			while (byt != -1) {
				System.out.print((char) byt);
				byt = reader.read();
			}
			
			// other ways to read comment this out first, then comment code above
			// to run code below
//			int firstByte = reader.read();
//			System.out.println("First character in file: " + (char) firstByte);
//
//			byte[] nextThree = reader.readNBytes(3);
//
//			System.out.print("Next 3 characters in file: ");
//			for (byte c : nextThree) {
//				System.out.print((char) c);
//			}
//			System.out.println();
//
//			byte[] restOfBytes = reader.readAllBytes();
//			System.out.println("Rest of characters in file: ");
//			for (byte c : restOfBytes) {
//				System.out.print((char) c);
//			}
				

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

