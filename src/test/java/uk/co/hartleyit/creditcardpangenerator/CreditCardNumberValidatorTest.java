package uk.co.hartleyit.creditcardpangenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public final class CreditCardNumberValidatorTest {
	
	
	@DataProvider(name = "pans")
	private Object[][] createPans() {
		return new Object[][] { {"5301250070000050"},  };
	}
	
	@Test(dataProvider="pans")
	public void validate(String pan) {
		assertThat(CreditCardNumberValidator.validate(pan)).isTrue();
	}

}
