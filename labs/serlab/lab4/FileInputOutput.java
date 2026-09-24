package lab4;
// CSC 111L - Lab 4
// Hernest Koroli

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class FileInputOutput {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("What would you like to name your file?");
		File fileName = new File(input.nextLine() + ".txt");

		System.out.println("What would you like to add to your file?");
		String contents = input.nextLine();

		writeFile(fileName, contents);
		readFile(fileName);

		input.close();
	}

	public static void writeFile(File file, String fileContents) {
		try(PrintWriter fileToWrite = new PrintWriter(file)) {
			fileToWrite.println(fileContents);
			fileToWrite.close();

			System.out.println("Success! Your file has been created.");
		} catch (FileNotFoundException e) {
			System.out.println("File either not found or created");
		}
	}


	public static void readFile(File file) {
		try (Scanner fileInput = new Scanner(file)) {
			while(fileInput.hasNext()) {
				System.out.println(fileInput.nextLine());
			}
			System.out.println("This is the end of the file");
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found for reading");
		}
	}
}