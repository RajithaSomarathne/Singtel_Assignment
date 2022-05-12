package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public TodoPage todoListPage;

	public WebDriver driver;

	public PageObjectManager(WebDriver driver){
		this.driver = driver;
	}

	public TodoPage getTodoListPage(){
		todoListPage= new TodoPage(driver);
		return todoListPage;
	}

}
