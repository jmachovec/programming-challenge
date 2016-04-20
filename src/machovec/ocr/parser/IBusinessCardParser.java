package machovec.ocr.parser;

/**
 * IBusinessCardParser provides the method signature for the method
 * used to parse and return contact info from an input document string.
 *
 */
interface IBusinessCardParser {
	IContactInfo getContactInfo(String document);
}
