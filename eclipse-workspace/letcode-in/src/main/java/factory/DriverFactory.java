package factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver;

	public static final Logger log = LogManager.getLogger(DriverFactory.class);

	public WebDriver initBrowser(String browserName) {

		switch (browserName.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			log.info("Browser open in: " + browserName);
			break;

		case "firefox":
			driver = new FirefoxDriver();
			log.info("Browser open in: " + browserName);
			break;

		case "edge":
			driver = new EdgeDriver();
			log.info("Browser open in: " + browserName);
			break;

		default:
			log.info("please pass the right browser name");
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

		return driver;

	}

	public WebDriver getDriver() {
		return driver;

	}

}
