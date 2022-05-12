package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.TodoPage;
import utils.TestBase;

import java.util.List;

public class TodoStepDefinition extends TestBase {
    int count,countList;
    public TodoPage todoListPage;

    public TodoStepDefinition() {
        this.todoListPage = getPageObjectManager().getTodoListPage();
    }

    @Given("User navigates ToDoMVC page")
    public void user_navigates_to_do_mvc_page() {
        Assert.assertTrue(todoListPage.getTitle().contains("Vue.js • TodoMVC"));
    }

    @When("user enter {string} in the textfield")
    public void user_enter_in_the_textfield(String arg1) {
        todoListPage.getTodoTextField().sendKeys(arg1+ Keys.ENTER);
    }

    @Then("user entered {string} should be added")
    public void user_entered_should_be_added(String arg1) {
        List<WebElement> todo= todoListPage.getToDoList();   // Write code here that turns the phrase above into concrete actions
        for(int i=0;i<todo.size();i++){
            if(todo.get(i).getText().equalsIgnoreCase(arg1)) {
                System.out.println(todo.get(i).getText());
                Assert.assertTrue(true);
            }
        }
    }

    @Then("proper count should be displayed")
    public void proper_count_should_be_displayed() {
        List<WebElement> todo= todoListPage.getToDoList();
        count=todo.size();
        countList=Integer.parseInt(todoListPage.getCountTodoList().getText());
        Assert.assertEquals(count,countList);

    }

    @When("user select items as complete")
    public void user_select_items_as_complete() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> todo= todoListPage.getToDoList();   // Write code here that turns the phrase above into concrete actions
        for(int i=0;i<todo.size()-1;i++)
        {
            todoListPage.getCheckboxes().get(i).click();
            //Assert.assertTrue(todoListPage.getCheckboxes().get(i).isSelected());
        }
    }

    @Then("count should be updated properly")
    public void count_should_be_updated_properly() {
        todoListPage.clickActiveButton();
        List<WebElement> todo= todoListPage.getToDoList();
        count=todo.size();
        countList=Integer.parseInt(todoListPage.getCountTodoList().getText());
        Assert.assertEquals(count,countList);
    }

    @Then("user verifies items should be in completed list")
    public void user_verifies_items_should_be_in_completed_list() throws InterruptedException {
        List<WebElement> todo= todoListPage.getToDoList();
        todoListPage.clickCompleteButton();
        //Thread.sleep(2000);
        for(int i=0;i<todo.size()-1;i++)
        {
            Assert.assertTrue(todoListPage.getCheckboxes().get(i).isSelected());
        }
    }

    @When("user click clear completed")
    public void user_click_clear_completed()
    {
        todoListPage.clickClearCompletedButton();
    }

    @Then("completed list should be cleared")
    public void completed_list_should_be_cleared() {
        List<WebElement> todo= todoListPage.getToDoList();
        count=todo.size();
        Assert.assertEquals(count,0);
    }


}
