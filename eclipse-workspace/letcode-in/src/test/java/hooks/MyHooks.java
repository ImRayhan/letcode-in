package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks {

	WebDriver driver;

	private DriverFactory driverFactory;

	@Before
	public void setup() {

		Properties prop = new ConfigReader().intializeProperties();
		driverFactory = new DriverFactory();
		driver = driverFactory.initBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void teardown() {
		
		//driver.quit();

	}

}
