package com.dhruyada.service.java;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		try {
			//This path doesn't exist so this is an exception
			List<String> allLines=  Files.readAllLines(Paths.get("somegarbagepath.txt")); 
		} catch (IOException e) {
			System.out.println("** Catch Block **");

			System.out.println("Exeption occured while reading lines from file: " + Arrays.toString(e.getStackTrace()));
			System.out.println("Error Message:");
			e.getMessage(); //Error Message associated with the Exception
			System.out.println("Error Cause:");
			e.getCause(); //Original Exception
			System.out.println("Error StackTrace:");
			e.printStackTrace(); //StackTrace
			
		} finally {
			System.out.println("Execute anything here irrespective of what happens");
		}
	}

}
