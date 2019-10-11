package javapractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) throws IOException {
		
		readTextFile("D:\\MyAutomationStuff\\GitStuff\\MyLearningHub\\data\\files\\file1.txt");
		readTextFile("D:\\MyAutomationStuff\\GitStuff\\MyLearningHub\\data\\files\\file2.csv");		
	}
	
	public static void readTextFile(String filePath) throws IOException{
		
		File f = new File(filePath);
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr);
		
		String line = reader.readLine();
		while(line != null){
			System.out.println(line);
			line = reader.readLine();
		}	
	}

}
