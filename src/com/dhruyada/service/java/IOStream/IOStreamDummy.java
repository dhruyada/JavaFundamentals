package com.dhruyada.service.java.IOStream;

import java.io.File;

public class IOStreamDummy {
	
	public static void main(String[] args) {
		File file = new File("testDirectory"); //passing file name to constructor
		file.mkdir();
		
		file = new File("testDir2\\innerDir");
		file.mkdirs();
		
		file = new File("testDir30" + File.separator + "innerDir");
		if(file.mkdirs()) {
			System.out.println("Dirs created");
		}else {
			System.out.println("Dir already exist");
		}

		System.out.println("File Separator: " + File.separator);
		System.out.println("Path Separator: " + File.pathSeparator);
		
		System.out.println(file.getAbsolutePath());
		
		
	}
}
