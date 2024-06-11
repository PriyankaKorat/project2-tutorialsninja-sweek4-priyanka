package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.DesktopsPage;
import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsMenu extends TestBase {
    DesktopsPage desktopsPage = new DesktopsPage();
    TopMenuTest topMenuTest = new TopMenuTest();
    HomePage homePage = new HomePage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        String menuName = "Desktops";
        //1.2 Click on “Show All Desktops”
        homePage.clickOnMenu(menuName);

        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.sortByProducts(desktopsPage.descOrderText);
        List<String> actualProductNames = desktopsPage.verifyProductOrder();
        List<String> expectedProductNames = desktopsPage.reverseProductOrder(actualProductNames);
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(actualProductNames, expectedProductNames, "Product is not in expected order.");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        desktopsPage.clickOnElement(desktopsPage.currencyDropdown);

        //2.2 Mouse hover on £Pound Sterling and click
        desktopsPage.clickOnElement(desktopsPage.poundSterling);

        //2.3 Mouse hover on Desktops Tab.
        //2.4 Click on “Show All Desktops”
        homePage.clickOnMenu(desktopsPage.deskTopsMenu);

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.sortByProducts(desktopsPage.ascOrderText);

        //2.6 Select product “HP LP3065”
        desktopsPage.clickOnElement(desktopsPage.selectOptionHP);

        //2.7 Verify the Text "HP LP3065"
        String actualHpText = desktopsPage.getVerificationText(desktopsPage.HPLPText);
        Assert.assertEquals( actualHpText, "HP LP3065", "Option Matched");

        //2.8 Select Delivery Date "2023-11-27"
        desktopsPage.selectDate("30", "November", "2023");

        //2.9.Enter Qty "1” using Select class.
        desktopsPage.clearTextFromTag(desktopsPage.clearText);

        //2.10 Click on “Add to Cart” button
        desktopsPage.clickOnElement(desktopsPage.addToCartPath);

        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String HPLPActualMessage = getTextFromElement(desktopsPage.HPLPSuccessText);
        String[] actualMsg = HPLPActualMessage.split("×");
        actualMsg[0].trim();
        String finalMessage = actualMsg[0];
        String HPLPExpectedMessage = finalMessage + "×";
        Assert.assertEquals(HPLPActualMessage, HPLPExpectedMessage, "Message");

        //2.12 Click on link “shopping cart” display into success message
        Thread.sleep(1000);
        desktopsPage.clickOnElement(desktopsPage.shoppingCart);

        //2.13 Verify the text "Shopping Cart"
        String expectedShoppingCartMessage = "Shopping Cart  (1.00kg)";
        String actualShoppingCartMessage = getTextFromElement(desktopsPage.shoppingCartMessage);
        Assert.assertEquals(actualShoppingCartMessage, expectedShoppingCartMessage, "Shopping Cart Success");

        //2.14 Verify the Product name "HP LP3065"
        String expectedHPMessage = "HP LP3065";
        String actualHPMessage = getTextFromElement(desktopsPage.actualHPText);
        Assert.assertEquals(actualHPMessage, expectedHPMessage, "Product does not match");

        //2.15 Verify the Delivery Date "2023-11-27"
        String expectedMessage = "2022-11-30";
        String actualMessage = getTextFromElement(desktopsPage.deliveryDateConformation);
        String[] actualMsg1 = actualMessage.split(":");
        Assert.assertEquals( actualMsg1[1],expectedMessage, "Delivery Date does not match");

        //2.16 Verify the Model "Product21"
        expectedMessage = "Product 21";
        actualMessage = getTextFromElement(desktopsPage.productMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Product does not verify model");

        //2.17 Verify the Total "£74.73"
        Assert.assertEquals("£74.73", getTextFromElement(desktopsPage.totPrice), "Price does not match");

    }

}




