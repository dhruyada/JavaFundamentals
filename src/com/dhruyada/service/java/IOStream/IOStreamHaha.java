package com.dhruyada.service.java.IOStream;

import java.io.*;

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
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))){
            bufferedWriter.newLine();
            bufferedWriter.write("some string in file");
            bufferedWriter.newLine();
            bufferedWriter.write("some other line");
        } catch (IOException e){
            System.out.println("IOException");
        }

        /**
         * Reader to read files
         */
        File readFile = new File("src/ReadFromHere.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(readFile))){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException io){

        }
    }
}
