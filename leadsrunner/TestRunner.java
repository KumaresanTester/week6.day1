package leadsrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/leadsfeatures", glue = "leadssteps", monochrome = true, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
