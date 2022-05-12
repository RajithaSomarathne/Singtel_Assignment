package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import pageObjects.PageObjectManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

	private static WebDriver driver;
	private static PageObjectManager pageObjectManager;

	public static WebDriver getWebDriver() throws IOException{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");


		String browser = browser_maven!=null ? browser_maven : browser_properties;

		if(driver == null){
			if(browser.equalsIgnoreCase("chrome")){
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();// driver gets the life
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}

		return driver;
	}

	public static PageObjectManager getPageObjectManager(){
		try{
			if (pageObjectManager == null) {
				pageObjectManager = new PageObjectManager(getWebDriver());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return pageObjectManager;
	}


}

