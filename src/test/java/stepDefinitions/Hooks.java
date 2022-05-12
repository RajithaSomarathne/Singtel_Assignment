package stepDefinitions;

import org.testng.annotations.AfterSuite;
import utils.TestBase;

import java.io.IOException;

public class Hooks {
    @AfterSuite
    public void AfterScenario() throws IOException
    {
        TestBase.getWebDriver().quit();
    }
}
