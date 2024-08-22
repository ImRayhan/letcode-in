package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class InputPage {

	private WebDriver driver;

	private ElementUtils elementUtils;

	public InputPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(linkText = "Edit")
	private WebElement inputEditElement;

	@FindBy(id = "fullName")
	private WebElement fullNameFieldElement;

	@FindBy(xpath = "//input[@id='join']")
	private WebElement appendTextFieldElement;

	@FindBy(id = "getMe")
	private WebElement readTextBoxFieldElement;

	@FindBy(id = "clearMe")
	private WebElement clearTextFieldElement;

	@FindBy(id = "noEdit")
	private WebElement disabledFieldElement;

	@FindBy(id = "dontwrite")
	private WebElement readonlyFieldElement;

	public void navigateInput() {

		elementUtils.waitAndClick(inputEditElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void inputFullNmaeAndAppendText(String fullName, String appenValue) {

		elementUtils.waitAndSendkeys(fullNameFieldElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME, fullName);

		elementUtils.waitAndSendkeys(appendTextFieldElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME, appenValue);
	}

	public String getValueFromTextBox(String value) {

		return elementUtils.waitGetElementValue(readTextBoxFieldElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME, value);

	}

	public void clearTextField() {

		elementUtils.waitClearText(clearTextFieldElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public boolean verifyInputFildDisabled() {

		return elementUtils.waitChekingDisabled(disabledFieldElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getValueReadonlyTextField(String value) {

		return elementUtils.waitGetElementValue(readonlyFieldElement, CommonUtils.EXPLISIT_WAIT_BASIC_TIME, value);

	}

	public String getInputPageTitle() {

		return driver.getTitle();

	}

	public String getInputPageUrl() {
		return driver.getCurrentUrl();

	}

}
