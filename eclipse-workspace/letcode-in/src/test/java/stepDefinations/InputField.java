package stepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InputPage;

public class InputField {

	private WebDriver driver;
	private InputPage inputPage;
	private DriverFactory driverFactory;

	@Given("I am in homepage and click input to navigate the input form")
	public void i_am_in_homepage_and_click_input_to_navigate_the_input_form() {

		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		inputPage = new InputPage(driver);
		inputPage.navigateInput();

	}

	@When("I fillup the input form {string} add value {string}")
	public void i_fillup_the_input_form_add_value(String string, String string2) {
		inputPage.inputFullNmaeAndAppendText(string, " " + string2);

	}

	@When("I retrive value from {string}")
	public void i_retrive_value_from(String string) {

		String expectedFieldValue = inputPage.getValueFromTextBox("value");

		assertEquals(expectedFieldValue, string);

	}

	@When("I Clear the text in clearField")
	public void i_clear_the_text_in_clear_field() {
		inputPage.clearTextField();

	}

	@When("I verify the email confirm field is enbled or not")
	public void i_verify_the_email_confirm_field_is_enbled_or_not() {

		boolean expectedFieldDisabled = inputPage.verifyInputFildDisabled();

		assertFalse(expectedFieldDisabled);

	}

	@When("I Confirm the text {string}")
	public void i_confirm_the_text(String string) {

		String expectedFieldValue = inputPage.getValueReadonlyTextField("value");

		assertEquals(expectedFieldValue, string);

	}

	@Then("I validate the title {string} and THE Url {string}")
	public void i_validate_the_title_and_the_url(String string, String string2) {

		String expectedTitle = inputPage.getInputPageTitle();
		String expectedUrl = inputPage.getInputPageUrl();

		assertEquals(expectedTitle, string);
		assertEquals(expectedUrl, string2);

	}

}
