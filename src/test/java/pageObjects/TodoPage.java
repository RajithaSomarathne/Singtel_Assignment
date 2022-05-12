package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodoPage {

    public WebDriver driver;

    public TodoPage(WebDriver driver)
    {
        this.driver=driver;
    }



    private By todoTextField = By.xpath("//input[@autofocus='autofocus']");

    private By todoList = By.xpath("//input[@class='toggle']/following-sibling::label");
    private By countTodoList=By.xpath("//span[@class='todo-count']/strong");
    private By checkBoxes=By.xpath("//input[@class='toggle']");
    private By activeBtn=By.xpath("//a[@href='#/active']");
    private By completedBtn=By.xpath("//a[@href='#/completed']");
    private By clearCompletedBtn=By.cssSelector("button.clear-completed");


    public WebElement getTodoTextField() {
        return driver.findElement(todoTextField);
    }

    public List<WebElement> getToDoList() {
        return driver.findElements(todoList);
    }

    public WebElement getCountTodoList() {
        return driver.findElement(countTodoList);
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(checkBoxes);
    }

    public void clickCompleteButton() {
        driver.findElement(completedBtn).click();
    }

    public void clickActiveButton() {
        driver.findElement(activeBtn).click();
    }

    public void clickClearCompletedButton() {
        driver.findElement(clearCompletedBtn).click();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
}
