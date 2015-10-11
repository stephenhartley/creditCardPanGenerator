package uk.co.hartleyit.creditcardpangenerator;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

public class CreditCardNumberGenerator {

	/**
	 * Generates a random valid credit card number. 
	 * @param bin
	 *            The bank identification number
	 * @param length
	 *            The total length including bin of the credit card
	 *            number.
	 * @return A randomly generated, valid, credit card number.
	 * @throws CheckDigitException
	 */
	public String generate(String bin, int length) throws CheckDigitException {
		int randomNumberLength = length - (bin.length() + 1);
		StringBuilder result = new StringBuilder(bin);
		result.append(RandomStringUtils.randomNumeric(randomNumberLength));
		result.append(new LuhnCheckDigit().calculate(result.toString()));
		return result.toString();
	}

}
