package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
glue = "stepDefinition" , monochrome = true , tags= "@RegisterUser")
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
