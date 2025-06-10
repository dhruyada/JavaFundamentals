package com.dhruyada.service.java;

import java.io.FileNotFoundException;

public class MyDummyException extends FileNotFoundException{
	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("You little dummy its a dummy exception");
		return super.getStackTrace();
	}
}
