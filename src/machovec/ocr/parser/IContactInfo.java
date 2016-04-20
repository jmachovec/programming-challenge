package machovec.ocr.parser;

/**
 * IContactInfo provides the method signature for the methods
 * used to get strings representing contact info (name, phone
 * number, email).
 *
 */
public interface IContactInfo {
	String getName();
    String getPhoneNumber();
    String getEmailAddress();
}
