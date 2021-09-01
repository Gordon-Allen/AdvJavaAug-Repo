package com.cognixia.jump.intermediateJava.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreams {

	public static void main(String[] args) {
		
//		File file = new File("resources/objectFile.data");
		File file = new File("resources/objectFile.txt");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("<== IOEXCEPTION: Could not create file 'objectFile' ==>");
			}
		}
		
//		writeObjectsToFile(file);
		readObjectsFromFile(file);

	}
	
	
	public static void writeObjectsToFile(File file) {
		
		try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			
			Person person = new Person("FooBar #42", 17);
			Student student = new Student("Foobar #2", 4.2);
			String hello = "Hello World!!!";
			
			
			writer.writeObject(person);
			writer.writeObject(student);
			writer.writeObject(hello);
			
			int num = 5;
			boolean bool = true;
			char ch = '#';
			
			writer.writeInt(num);
			writer.writeBoolean(bool);
			writer.writeChar(ch);
			
			
			int[] numArr = {1,5,4,9,8,7};
			writer.writeObject(numArr);
			
			
			List<String> strList = new ArrayList<String>();
			strList.add("str1");
			strList.add("str2");
			strList.add("str3");
			writer.writeObject(strList);
			
			System.out.println("SUCCESS: Wrote/Overwrote objects to 'objectFile'");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void readObjectsFromFile(File file) {
		
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
			Person person = (Person) reader.readObject();
			System.out.println("1st Object: " + person);
			
			
			Student student = (Student) reader.readObject();
			System.out.println("2nd Object: " + student);
			
			String hello = (String) reader.readObject();
			System.out.println("3rd Object: " + hello);
			
			int num = (int) reader.readInt();
			System.out.println("1st Primitive: " + num);
			
			boolean bool = (boolean) reader.readBoolean();
			System.out.println("2nd Primitive: " + bool);
			
			char ch = (char) reader.readChar();
			System.out.println("3rd Primitive: " + ch);
			
			int[] numArr = (int[]) reader.readObject();
			
			System.out.println("1st Collection: ");
			for( int n : numArr) {
				System.out.println(n);
			}
			
			
			@SuppressWarnings("unchecked")
			List<String> strList = (List<String>) reader.readObject();
			System.out.println("2nd Collection: ");
			for(String s : strList) {
				System.out.println(s);
			}
			
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
	

}
