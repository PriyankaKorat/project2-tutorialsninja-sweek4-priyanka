package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {
    HomePage homePage = new HomePage();

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    // string
    public void selectMenu(String menuName) {
        // Click on element
        homePage.clickOnMenu(menuName);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        String menuName = "Desktops"; // Example menu item
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu(menuName);
        //1.3 Verify the text ‘Desktops’
        String actualText = driver.getTitle();
        String expectedText = menuName;
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        String menuName = "Laptops & Notebooks";
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu(menuName);
        //2.3 Verify the text ‘Laptops & Notebooks’
        String actualText = driver.getTitle();
        String expectedText = menuName;
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        String menuName = "Components";
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu(menuName);
        //3.3 Verify the text ‘Components’
        String actualText = driver.getTitle();
        String expectedText = menuName;
        Assert.assertEquals(expectedText, actualText);
    }

}
