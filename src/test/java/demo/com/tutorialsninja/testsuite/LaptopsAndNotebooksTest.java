package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.DesktopsPage;
import demo.com.tutorialsninja.pages.HomePage;
import demo.com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LaptopsAndNotebooksTest {
    DesktopsPage desktopsPage = new DesktopsPage();
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException{
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        String menuName = laptopAndNotebooksPage.laptopMenu;
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnMenu(menuName);
        homePage.clickOnElement(desktopsPage.currencyDropdown);
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnElement(desktopsPage.£Pound);
        //1.3 Select Sort By "Price (High > Low)"
        homePage.mouseHoverToElementAndClick(laptopAndNotebooksPage.laptopAndNoteBookTable);
        //1.4 Verify the Product price will arrange in High to Low order.
        homePage.clickOnElement(desktopsPage.showAllLaptopAndNotebook);

        //Verify the Product will arrange in Descending order.
        List<Double> actualText = laptopAndNotebooksPage.getProductPricesInDefaultFilterAndSortByDescendingOrder();
        //Select Sort By position "Price high to low"
        laptopAndNotebooksPage.select(laptopAndNotebooksPage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        Thread.sleep(2000);
        List<Double> expectedText = laptopAndNotebooksPage.getProductPriceAfterFilterHighToLow();
        Assert.assertEquals(actualText, expectedText, "Product not in descending order");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse hover on Currency Dropdown and click
        homePage.clickOnElement(desktopsPage.currencyDropdown);

        //Mouse hover on £Pound Sterling and click
        homePage.clickOnElement(desktopsPage.£Pound);

        //Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverToElementAndClick(laptopAndNotebooksPage.laptopAndNoteBookTable);

        //Click on “Show All Laptops & Notebooks”
        homePage.clickOnElement(desktopsPage.showAllLaptopAndNotebook);

        //Select Sort By "Price (High > Low)"
        laptopAndNotebooksPage.select(laptopAndNotebooksPage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");

        //Select Product “Sony VAIO”
        homePage.clickOnElement(laptopAndNotebooksPage.sonyVAIO);

        //Verify the text “Sony VAIO”
        String expectedText = "Sony VAIO";
        String actualText = desktopsPage.getVerificationText(laptopAndNotebooksPage.sonyVAIOText);
        Assert.assertEquals(actualText, expectedText, "Text not match sony vaio");

        //Click on ‘Add To Cart’ button
        homePage.clickOnElement(laptopAndNotebooksPage.addToCartButton);

        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        expectedText = "Success: You have added Sony VAIO to your shopping cart!";
        actualText = desktopsPage.getVerificationText(laptopAndNotebooksPage.successText).substring(0, 56);
        Assert.assertEquals(actualText, expectedText, "Not success");

        //Click on link “shopping cart” display into success message
        homePage.clickOnElement(laptopAndNotebooksPage.shoppingCartButton);

        //Verify the text "Shopping Cart"
        expectedText = "Shopping Cart";
        actualText = desktopsPage.getVerificationText(laptopAndNotebooksPage.shoppingCartText).substring(0, 13);
        Assert.assertEquals(actualText, expectedText, "Shopping Cart does not match");

        //Verify the Product name "Sony VAIO"
        expectedText = "Sony VAIO";
        actualText = laptopAndNotebooksPage.setVerifyTheTextSonyVIAO();
        Assert.assertEquals(actualText, expectedText, "Sony VAIO not matched");

        //Change Quantity "2"
        laptopAndNotebooksPage.changeTheQty2();

        //Click on “Update” Tab
        laptopAndNotebooksPage.clickOnUpdateButton();

        //Verify the message “Success: You have modified your shopping cart!”
        expectedText = "Success: You have modified your shopping cart!";
        actualText = laptopAndNotebooksPage.verifyUpdatedCart();
        Assert.assertEquals(actualText, expectedText, "Shopping cart does not match");

        //Verify the Total £1,472.45
        expectedText = "£1,472.45";
        actualText = laptopAndNotebooksPage.verifyTheTotal();
        Assert.assertEquals(actualText, expectedText, "Total does not match");

        //Click on “Checkout” button
        laptopAndNotebooksPage.clickOnCheckout();

        //Verify the text “Checkout”
        expectedText = "Checkout";
        actualText = laptopAndNotebooksPage.verifyTheTextCheckout();
        Assert.assertEquals(actualText, expectedText, "Checkout does not match");

        //Verify the Text “New Customer”
        expectedText = "New Customer";
        actualText = laptopAndNotebooksPage.verifyTheTextNewCustomer();
        Assert.assertEquals(actualText, expectedText, "Text does not match");

        //Click on “Guest Checkout” radio button
        laptopAndNotebooksPage.clickOnGuestCheckout();

        //Click on “Continue” tab
        laptopAndNotebooksPage.clickOnContinue();

        //Fill the mandatory fields
        laptopAndNotebooksPage.enterFirstName();
        laptopAndNotebooksPage.enterLastName();
        laptopAndNotebooksPage.enterEmail();
        laptopAndNotebooksPage.enterTelephone();
        laptopAndNotebooksPage.enterAddress1();
        laptopAndNotebooksPage.enterCity();
        laptopAndNotebooksPage.enterPostcode();
        laptopAndNotebooksPage.enterState();

        //Click on “Continue” Button
        laptopAndNotebooksPage.clickOnContinueButton();

        //Add Comments About your order into text area
        laptopAndNotebooksPage.enterComment();
        laptopAndNotebooksPage.clickOnContinueAfterComment();

        //Check the Terms & Conditions check box
        laptopAndNotebooksPage.clickCheckBox();
        Thread.sleep(1000);
        laptopAndNotebooksPage.setContinueClicking();
        laptopAndNotebooksPage.clickOnConfirmButton();

        //Verify the message “Your order has been placed!”
        expectedText = "Your order has been placed!";
        actualText = laptopAndNotebooksPage.verifyOrderPlaced();
        Assert.assertEquals(actualText, expectedText, "Order does not placed");
    }

}
