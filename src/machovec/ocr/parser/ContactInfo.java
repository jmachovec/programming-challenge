package machovec.ocr.parser;

/**
 * ContactInfo provides the set methods necessary to store contact 
 * info (name, phone number, email) and implements the get methods
 * provided by the IContactInfo interface.
 * 
 */
public class ContactInfo implements IContactInfo{
	
	private String name;
	private String phoneNumber;
	private String email;
	
	public ContactInfo() {
		this.name = null;
		this.phoneNumber = null;
		this.email = null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	@Override
	public String getEmailAddress() {
		return this.email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String email) {
		this.email = email;
	}
}
