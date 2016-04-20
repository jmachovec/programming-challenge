package machovec.ocr.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * OcrParser contains the main method to run several test cases 
 * for the Business Card OCR application. 
 *
 */
public class OcrParser {
	
	public static void main(String[] args) {
		
		String document1 = parseDocument("example1.txt");
		String document2 = parseDocument("example2.txt");
		String document3 = parseDocument("example3.txt");

		if (!document1.isEmpty()) {
			parseInfo(document1);
		}
		
		if (!document2.isEmpty()) {
			parseInfo(document2);
		}
		
		if (!document3.isEmpty()) {
			parseInfo(document3);
		}
	}
	
	
	/**
	 * parseDocument parses an example document text file and returns 
	 * a string containing the contact info.
	 * 
	 */
	public static String parseDocument(String fileName) {

		String document = "";
        File file = new File(fileName);
        
        try {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				document = document + scanner.nextLine() + '\n';
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Error! File " + fileName + " not found.");
		}
		return document;
	}
	
	/**
	 * parseInfo parses a string containing contact info and outputs
	 * the formatted contact info.
	 * 
	 */
	public static void parseInfo(String document) {
		
		System.out.println('\n' + document);
		
		BusinessCardParser parser = new BusinessCardParser();
		IContactInfo info = parser.getContactInfo(document);

		System.out.println("Name: " + info.getName());
		System.out.println("Phone: " + info.getPhoneNumber());
		System.out.println("Email: " + info.getEmailAddress());
	}

}
