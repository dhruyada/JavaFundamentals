package com.dhruyada.service.java.IOStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
		
		String exampleWriteString = "This is a test string " + System.lineSeparator() + "This is a new line";
		
		file = new File("csvDir/file.csv");
		try {
			file.createNewFile();	//Created a new empty file
//			file.delete(); //this will delete the file or dir
		} catch (IOException e) {
			System.out.println("got error while creating file");
			System.out.println("Checking if parent dir exists " + file.getParentFile().exists());
			//lets ensure that folder exists 
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("got error while creating file");
			System.out.println("Checking if parent file exists now " + file.exists());
		}
		
		
//		Other Important apis
		
//		 Path Info
//		 Method	Description
//		 getName()	Returns the name of the file or directory
//		 getPath()	Returns the path used to create the file
//		 getAbsolutePath()	Returns the absolute path
//		 getParent()	Returns the parent directory path
//		 getCanonicalPath()	Returns the unique, absolute path after resolving . and ..
		
//		exists()	Checks if file or directory exists
//		isFile()	Checks if it's a file
//		isDirectory()	Checks if it's a directory
//		canRead() / canWrite() / canExecute()	Checks permissions
		
//		list()	Lists names of files/directories as String[]
//				listFiles()	Lists files/directories as File[]
//				list(FilenameFilter)	Filtered list by name
//				listFiles(FileFilter)	Filtered list by file properties
		
		
//		Files.createFile(Path)
//		Files.createDirectory(Path)
//		Files.createDirectories(Path)
//		Files.delete(Path)
//		Files.exists(Path)
//		Files.copy(source, target)
//		Files.move(source, target)
//		Files.write(Path, byte[] or List<String>)
//		Files.readAllBytes(Path)
//		Files.readAllLines(Path)
		
		
		
		File[] listFiles = file.listFiles(pathName -> 
			pathName.getName().endsWith(".java"));
		
		
		
		
		
//		NIO class 
		Path path = Paths.get("nioDir", "innerNioDir");
		Files.isDirectory(path);
		
		
	}
}
