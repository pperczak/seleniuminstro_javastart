package examples;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class VanillaJSExample extends VanillaJSExampleHelper{

    @Test
    public void addSomeElementsToTheList() {
        VanillaJSPage vanillaJSPage = new VanillaJSPage(driver);

        vanillaJSPage.addNewToDo("abcd").addNewToDo("eorsodfos").addNewToDo("gunwo").addNewToDo("12");

        //System.out.println(vanillaJSPage.howManyListElements());

        assertEquals(vanillaJSPage.howManyListElements(),4);

    }

    @Test
    public void addElementsToTheListSmarter() {

        VanillaJSPage vanillaJSPage = new VanillaJSPage(driver);
        List<String> listToAddToWebPage = Arrays.asList("Gunwo","123","badum tsss","a11aa");

        for (String toDo: listToAddToWebPage) {
            vanillaJSPage.addNewToDo(toDo);
        }
        assertEquals(vanillaJSPage.howManyListElements(),listToAddToWebPage.size());

    }

    @Test
    public void checkIfAllTasksAreCompleted() {
        VanillaJSPage vanillaJSPage = new VanillaJSPage(driver);
        List<String> listToAddToWebPage = Arrays.asList("Gunwo","123","badum tsss","a11aa");

        for (String toDo: listToAddToWebPage) {
            vanillaJSPage.addNewToDo(toDo);
        }
        boolean isCompleted=vanillaJSPage.checkAllCheckBoxes().isCompleted();
        System.out.println("isCompleted? "+isCompleted);

        vanillaJSPage.listAllTasksByName();

    }

}
