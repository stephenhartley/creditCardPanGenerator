package uk.co.hartleyit.creditcardpangenerator;

import org.apache.commons.validator.routines.CodeValidator;
import org.apache.commons.validator.routines.CreditCardValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

public class CreditCardNumberValidator {
	
	private static final String PAN_PATTERN = "(^\\d+$)";

	public static boolean validate(String candidatePan)  {
		RegexValidator rv = new RegexValidator(PAN_PATTERN);
		CodeValidator cv = new CodeValidator(rv, 12, 19, new LuhnCheckDigit());
		CodeValidator[] cvs = new CodeValidator[1];
		cvs[0] = cv;
		CreditCardValidator ccv = new CreditCardValidator(cvs);
		return ccv.isValid(candidatePan);
	}

}
