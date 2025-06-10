package com.dhruyada.service.java;

import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		try {
			dummyExceptionCallExample();
		} catch (MyDummyException mde) {
			System.out.println("It was a dummy but we caught it " + Arrays.toString(mde.getStackTrace()));
		}
		
		
	}
	
	public static void dummyExceptionCallExample() throws MyDummyException {
		try {
			//This path doesn't exist so this is an exception
			List<String> allLines=  Files.readAllLines(Paths.get("somegarbagepath.txt")); 
		} catch (NoSuchFileException fnfe) {
			//FileNotFoundException is a subclass of IOException so it would never reach here if order is reversed
			System.out.println("File Not Found Exeption in Catch Block");
			throw new MyDummyException();
		} catch (IOException e) {
			System.out.println("** Catch Block **");

			System.out.println("Exeption occured while reading lines from file: " + Arrays.toString(e.getStackTrace()));
			System.out.println("Error Message:");
			e.getMessage(); //Error Message associated with the Exception
			System.out.println("Error Cause:");
			e.getCause(); //Original Exception
			System.out.println("Error StackTrace:");
			e.printStackTrace(); //StackTrace
			
			// we saw that actual error in this case is FileNotFoundException
			// lets add that catch block here
			
		} finally {
			System.out.println("Execute anything here irrespective of what happens");
		}
	}

}
