package machovec.ocr.parser;

import java.util.Scanner;

/**
 * BusinessCardParser provides the methods necessary to parse a
 * String object to determine if the String contains a valid
 * set of contact info (name, phone number, email).
 *
 */
public class BusinessCardParser implements IBusinessCardParser {

	/**
	 * getContactInfo parses a document to determine if it contains
	 * a valid name, phone number, or email address.
	 *
	 */
	@Override
	public IContactInfo getContactInfo(String document) {
		
		ContactInfo contactInfo 	= new ContactInfo();
		
		Scanner emailScanner 		= new Scanner(document);
		Scanner phoneNumberScanner 	= new Scanner(document);
		Scanner nameScanner 		= new Scanner(document);
		
		boolean emailNotFound 		= true;
		boolean phoneNumberNotFound	= true;
		boolean nameNotFound 		= true;
		
		while (emailScanner.hasNextLine() && emailNotFound) {		
			
			if (isEmailAddress(contactInfo, emailScanner.nextLine())) {
				emailNotFound = false;
			}
		}
		
		while (phoneNumberScanner.hasNextLine() && phoneNumberNotFound) {		
			
			if (isPhoneNumber(contactInfo, phoneNumberScanner.nextLine())) {
				phoneNumberNotFound = false;
			}
		}

		while (nameScanner.hasNextLine() && nameNotFound) {		
			
			if (isName(contactInfo, nameScanner.nextLine())) {
				nameNotFound = false;
			}
		}
		
		emailScanner.close();
		phoneNumberScanner.close();
		nameScanner.close();
		
		return contactInfo;
	}
	
	/**
	 * isPhoneNumber checks to determine if the input string consists of 10-11
	 * numeric characters. Note that this algorithm assumes that the telephone
	 * number will always appear before a fax number.
	 * 
	 */
	public Boolean isPhoneNumber(ContactInfo contactInfo, String phoneNumber) {	
		
		Boolean success = false;

		if (phoneNumber.replaceAll("[\\D]", "").matches("[\\d]{10,11}")) {
			contactInfo.setPhoneNumber(phoneNumber.replaceAll("[\\D]", ""));
			success = true;
		}
		
		return success;
	}
	
	/**
	 * isEmailAddress checks to determine if the input string consists of a
	 * pattern matching a typical email format (including @ symbol).
	 * 
	 */
	public Boolean isEmailAddress(ContactInfo contactInfo, String email) {	
		
		Boolean success = false;

		if (email.matches("(^[\\w.-]+@[\\w-]+\\.[\\w]+$)")) {
			contactInfo.setEmailAddress(email);
			success = true;
		}
		return success;
	}
	
	/**
	 * isName uses a substring of the contact info email address to determine
	 * if the input string consists of a name. This is accomplished by isolating
	 * the second word appearing in the string (presumed to be the last name)
	 * and checking to see if this word appears within the substring of the email
	 * address (the portion of the email address appearing before the @ symbol).
	 * Note that this algorithm is NOT adequate for use in a released product, 
	 * however it should function correctly for the examples provided.
	 * 
	 */
	public Boolean isName(ContactInfo contactInfo, String name) {	
		
		Boolean success = false;
		
		if (name.matches("(^[A-Z]{1}[a-z]+[ ]{1}[A-Z]{1}[a-z]+$)")) {			
			String[] fullName = name.split(" ");
			String email = contactInfo.getEmailAddress();
			String emailPrefix = email.substring(0, email.indexOf("@"));
			
			if (emailPrefix.toLowerCase().contains(fullName[1].toLowerCase())) {
				contactInfo.setName(name);
				success = true;
			}
		}
		return success;
	}
	
}
