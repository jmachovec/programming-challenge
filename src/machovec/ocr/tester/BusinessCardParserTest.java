package machovec.ocr.tester;

import org.junit.Test;
import org.junit.Assert;
import machovec.ocr.parser.*;

/**
 * BusinessCardParserTest runs a simple JUnit test to verify that each 
 * of the methods used to parse contact info is able to correctly 
 * identify which string represents the name, phone number, and email.
 *
 */
public class BusinessCardParserTest {
	
	@Test
	public void test() {
		
		String document =	"Foobar Technologies\n" +
							"Analytic Developer\n" +
							"Lisa Haung\n" +
							"1234 Sentry Road\n" +
							"Columbia, MD 12345\n" +
							"Phone: 410-555-1234\n" +
							"Fax: 410-555-4321\n" +
							"lisa.haung@foobartech.com";

		BusinessCardParser parser = new BusinessCardParser();
		IContactInfo info = parser.getContactInfo(document);
		
		Assert.assertEquals("Lisa Haung", info.getName());
		Assert.assertEquals("4105551234", info.getPhoneNumber());
		Assert.assertEquals("lisa.haung@foobartech.com", info.getEmailAddress());
	}
}
