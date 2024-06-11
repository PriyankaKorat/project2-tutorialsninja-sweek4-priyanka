package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.DesktopsPage;
import demo.com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import demo.com.tutorialsninja.pages.MyAccountsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest {
    MyAccountsPage myAccountsPage = new MyAccountsPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        myAccountsPage.selectMyAccountOptions(myAccountsPage.register);
        //1.3 Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = desktopsPage.getVerificationText(myAccountsPage.registerAccountText);
        Assert.assertEquals(actualText, expectedText, "Not register account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        myAccountsPage.selectMyAccountOptions(myAccountsPage.login);
        //2.3 Verify the text “Returning Customer”.
        String expectedText = "Returning Account";
        String actualText = desktopsPage.getVerificationText(myAccountsPage.returningCustomerText);
        Assert.assertEquals(actualText, expectedText, "Not register account");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        myAccountsPage.selectMyAccountOptions(myAccountsPage.register);

        //3.3 Enter First Name
        myAccountsPage.enterFirstName();

        //3.4 Enter Last Name
        myAccountsPage.enterLastName();

        //3.5 Enter Email
        myAccountsPage.enterEmail();

        //3.6 Enter Telephone
        myAccountsPage.enterPhoneNumber();

        //3.7 Enter Password
        myAccountsPage.enterPassword();

        //3.8 Enter Password Confirm
        myAccountsPage.enterConfirmPassword();

        //3.9 Select Subscribe Yes radio button
        myAccountsPage.selectYesRadioButton();

        //3.10 Click on Privacy Policy check box
        myAccountsPage.checkedPrivacyCheckBox();

        //3.11 Click on Continue button
        myAccountsPage.clickContinue();

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedCreation = "Your Account Has Been Created!";
        //actual text
        String actualCreation = desktopsPage.getVerificationText(myAccountsPage.accountCreationTextMessage);
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(actualCreation, expectedCreation, "account not created");

        //3.13 Click on Continue button
        myAccountsPage.clickingContinue();

        //3.14 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        myAccountsPage.selectMyAccountOptions(myAccountsPage.logout);

        //3.16 Verify the text “Account Logout”
        String expectedLogoutText = "Account Logout";
        String actualLogoutText = myAccountsPage.accountLogoutText();
        Assert.assertEquals(actualLogoutText, expectedLogoutText);

        //3.17 Click on Continue button
        myAccountsPage.clickOnFinalContinue();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        myAccountsPage.selectMyAccountOptions(myAccountsPage.login);
        //4.3 Enter Email address
        myAccountsPage.enterEmail();

        //4.4 Enter Last Name
        myAccountsPage.enterLastName();

        //4.5 Enter Password
        myAccountsPage.enterPassword();

        //4.6 Click on Login button
        myAccountsPage.clickOnLogin();

        //4.7 Verify text “My Account”
        String expectedMyAccountText = "My Account";
        String actualMyAccountText = myAccountsPage.myAccountText();
        Assert.assertEquals(actualMyAccountText, expectedMyAccountText, "Not on my account");

        //4.8 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        myAccountsPage.selectMyAccountOptions(myAccountsPage.logout);

        //4.10 Verify the text “Account Logout”
        String expectedAccountLogoutText = "Account Logout";
        String actualAccountLogoutText = myAccountsPage.accountLogoutText();
        Assert.assertEquals(actualAccountLogoutText, expectedAccountLogoutText, "Not logged out");

        //4.11 Click on Continue button
        myAccountsPage.clickOnFinalContinue();
    }

}
