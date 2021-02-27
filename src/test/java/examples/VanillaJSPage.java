package examples;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VanillaJSPage {

    @FindBy(xpath = "//input[@class='new-todo']")
    private WebElement newToDo;

    @FindBy(xpath = "//ul[@class='todo-list']//li")
    private List<WebElement> toDoList;

    @FindBy(xpath = "//input[@class='toggle']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//ul[@class='todo-list']/li")
    private List<WebElement> checkboxesAttributes;

    public VanillaJSPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public VanillaJSPage addNewToDo(String taskToBeAdded) {
        newToDo.sendKeys(taskToBeAdded);
        newToDo.sendKeys(Keys.ENTER);
        return this;
    }

    public VanillaJSPage checkAllCheckBoxes() {
        for (WebElement el: checkboxes) {
            el.click();
        }
        return this;
    }

    public boolean isCompleted() {
        for (WebElement el: checkboxesAttributes) {
            System.out.println("Atrribute: "+el.getAttribute("class"));
            if(!el.getAttribute("class").equals("completed"))
                return false;
        }
        return true;
    }

    public int howManyListElements() {
        return toDoList.size();
    }

    public void listAllTasksByName() {
        for (WebElement el: toDoList) {
            System.out.println("Task: "+el.getText());
        }
    }

}
