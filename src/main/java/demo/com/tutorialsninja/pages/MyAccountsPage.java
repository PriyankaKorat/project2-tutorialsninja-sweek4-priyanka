package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsPage extends Utility {
    public String register = "Register";
    public String login = "Login";
    public String logout = "Logout";
    By selectMultipleElementFromDropdown = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li");
    By ClickOnMyAccountLink = By.xpath("//span[normalize-space()='My Account']");
    public By registerAccountText = By.xpath("//h1[normalize-space()='Register Account']");
    public By returningCustomerText = By.xpath("//h2[normalize-space()='Returning Customer']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By emailId = By.id("input-email");
    By mobileNumber = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.name("confirm");
    By yesRadioButton = By.name("newsletter");
    By privacyPolicyCheckBox = By.name("agree");
    By clickContinue = By.xpath("//input[@value='Continue']");
    public By accountCreationTextMessage = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By clickingOnContinue = By.xpath("//a[@class='btn btn-primary']");
    By clickOnLoginButton = By.xpath("//input[@value='Login']");
    By accountLogOutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By finalContinue = By.xpath("//a[@class='btn btn-primary']");
    By myAccountText = By.xpath("//h2[normalize-space()='My Account']");

    public void selectMyAccountOption(String option) {
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }

    public void clickOnMyAccountLink() {
        clickOnElement(ClickOnMyAccountLink);
    }

    public void selectMyAccountOptions(String option) {
        //This method should click on the options whatever name is passed as parameter. //list with two options(do multi select)
        List<WebElement> registerList = getMultipleElements(selectMultipleElementFromDropdown); //list with two options(do multi select)
        for (WebElement option1 : registerList) {
            if (option1.getText().equals(option)) {
                option1.click();
                break;
            }
        }
    }

    public void enterFirstName() {
        sendTextToElement(firstName, "Priyanka");
    }

    public void enterLastName() {
        sendTextToElement(lastName, "Korat");
    }

    public void enterEMail() {
        generateRandomEmail(emailId, "sanganipriyanka8@gmail.com");
    }

    public void enterPhoneNumber() {
        sendTextToElement(mobileNumber, "0404587954");
    }

    public void enterPassword() {
        sendTextToElement(password, "Test@123");
    }

    public void enterConfirmPassword() {
        sendTextToElement(confirmPassword, "Test@123");
    }

    public void selectYesRadioButton() {
        clickOnElement(yesRadioButton);
    }

    public void checkedPrivacyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickContinue() {
        clickOnElement(clickContinue);
    }

    public String accountCreationText() {
        return getTextFromElement(accountCreationTextMessage);
    }

    public void clickingContinue() {
        clickOnElement(clickingOnContinue);
    }


    public String accountLogoutText() {
        return getTextFromElement(accountLogOutText);
    }

    public void clickOnFinalContinue() {
        clickOnElement(finalContinue);
    }

    public void enterEmail() {
        sendTextToElement(emailId, "sanganipriyanka8@gmail.com");
    }

    public void clickOnLogin() {
        clickOnElement(clickOnLoginButton);
    }

    public String myAccountText() {
        return getTextFromElement(myAccountText);
    }

}
