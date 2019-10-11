package javapractice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter1 {

	public static void main(String[] args) throws IOException {

//		writeCSVFile("D:\\MyAutomationStuff\\GitStuff\\MyLearningHub\\data\\files\\file2.csv");

		writeCSVFile("D:\\MyAutomationStuff\\GitStuff\\MyLearningHub\\data\\files\\file2.csv");	
	}

	public static void writeCSVFile(String filePath) throws IOException{

		File f = new File("D:\\MyAutomationStuff\\GitStuff\\MyLearningHub\\data\\files\\file2.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fw);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				writer.write(Math.random()+",");
			}
			writer.write("\n");
		}
		writer.close();
		System.out.println("File writing is successfull");	
	}

	public static void writeTextFile(String filePath) throws IOException{

		File f = new File("D:\\MyAutomationStuff\\GitStuff\\MyLearningHub\\data\\files\\file2.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fw);

		writer.write("Hellow this is firts line"+"\n");
		writer.write("Hellow this is second line"+"\n");
		writer.write("Hellow this is third line"+"\n");
		writer.write("Hellow this is fourth line"+"\n");
		writer.close();
		System.out.println("File writing is successfull");	
	}

}
