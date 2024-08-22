package utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	Logger log = LogManager.getLogger(ElementUtils.class);

	public WebElement waitForelement(WebElement element, long waitTime) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			element = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			log.info("element not visible: " + element);
		}

		return element;

	}

	public void waitAndClick(WebElement element, long waitTime) {

		waitForelement(element, waitTime).click();

	}

	public void waitAndSendkeys(WebElement element, int timeWait, String value) {

		waitForelement(element, timeWait).sendKeys(value);

	}

	public String waitGetElementValue(WebElement webElement, int waitTime, String value) {

		return waitForelement(webElement, waitTime).getAttribute(value);

	}

	public void waitClearText(WebElement element, int waitTime) {

		waitForelement(element, waitTime).clear();

	}

	public boolean waitChekingDisabled(WebElement element, int waitTime) {

		return waitForelement(element, waitTime).isEnabled();

	}

}
