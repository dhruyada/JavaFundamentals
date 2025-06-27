package com.dhruyada.service.java.IOStream;

import java.io.File;
import java.io.IOException;

public class IOStreamHaha {


    public static void main(String[] args) throws IOException {
        File file = new File("src/example_java_file.txt");
        file.createNewFile();

        File file_folder = new File("src/example_folder");
        if(file_folder.mkdir()){
            System.out.println("Folder Created");
        }else {
            System.out.println("Folder already exists");
        }
    }

}
