package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue ="stepDefinitions", monochrome = false,
        plugin = {"html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
