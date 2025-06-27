package com.dhruyada.service.java.IOStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOStreamHaha {


    public static void main(String[] args) throws IOException {
        File file = new File("src/example_java_file.txt");
        file.createNewFile();

        File file_folder = new File("src/example_folder");
        // mkdirs can create complete path
        if(file_folder.mkdir()){
            System.out.println("Folder Created");
        }else {
            System.out.println("Folder already exists");
        }

        /**
         * Writing Content in a file
         */
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/example_java_file.txt"))){
            bufferedWriter.write("some string in file");
        } catch (IOException e){
            System.out.println("IOException");
        }
    }
}
