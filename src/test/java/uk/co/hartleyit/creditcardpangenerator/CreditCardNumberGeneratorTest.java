package uk.co.hartleyit.creditcardpangenerator;

import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public final class CreditCardNumberGeneratorTest {
	
	private static final String FIRST_DIRECT_VISA = "454312";
	private static final String NATWEST_MASTERCARD = "552213"; 
	private static final String AMERICAN_EXPRESS = "374604"; 
	
	@DataProvider(name = "bins")
	private Object[][] createBins() {
		return new Object[][] { {FIRST_DIRECT_VISA}, {NATWEST_MASTERCARD}, {AMERICAN_EXPRESS} };
	}
	
	@Test(dataProvider="bins")
	public void getSomeNumbers(String bin) throws CheckDigitException {
		CreditCardNumberGenerator generator = new CreditCardNumberGenerator();
		for(int length=12; length<=19; length++) {
			String pan = generator.generate(bin, length);
//			System.out.println("{ \"" + pan + "\", \"" + pan + "\" },");
			System.out.println("{ \"" + pan + "\" },");
		}
	}

}
