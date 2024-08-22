package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/features",
                  glue = {"stepDefinations","hooks"}, 
                  plugin = {"pretty","html:target/cucumberReports/CucumberReports.html"},
                  tags = "@regression",
                  dryRun = false,
                  monochrome = true

)

public class TestRunner {

}
