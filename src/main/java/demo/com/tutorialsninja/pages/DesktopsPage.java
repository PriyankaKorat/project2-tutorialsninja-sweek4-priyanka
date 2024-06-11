package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    public String deskTopsMenu = "Desktops";
    public By sortByOptions = By.xpath("//select[@id='input-sort']");
    public By productName = By.xpath("//div[@class='caption']//h4");
    public String descOrderText = "Name (Z - A)";
    public String ascOrderText = "Name (A - Z)";
    public By currencyDropdown = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    public By poundSterling = By.xpath("//button[normalize-space()='£Pound Sterling']");
    public By selectOptionHP = By.linkText("HP LP3065");
    public By HPLPText  = By.xpath("//h1[normalize-space()='HP LP3065']");
    public By calendarPath = By.xpath("//i[@class='fa fa-calendar']");
    public By monthYearPath = By.xpath("(//th[@class='picker-switch'])[1]");
    public By daysPath = By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]");
    public By allDates = By.xpath("//*[@class='datepicker-days']//tbody//tr//td");
    public By clearText = By.xpath("//input[@id='input-quantity']");
    public By addToCartPath = By.xpath("//button[@id='button-cart']");
    public By HPLPSuccessText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By shoppingCart = By.linkText("shopping cart");
    public By shoppingCartMessage = By.xpath("//body/div/div/div/h1[1]");
    public By actualHPText = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    public By deliveryDateConformation = By.xpath("(//small)[2]");
    public By productMessage = By.xpath("//td[normalize-space()='Product 21']");
    public By totPrice = By.xpath("(//td[contains(text(),'£74.73')])[4]");
    public By £Pound = By.xpath("//button[normalize-space()='£Pound Sterling']");
    public By showAllDesktop = By.xpath("//a[normalize-space()='Show AllDesktops']");
    public By showAllLaptopAndNotebook = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");

    public void sortByProducts(String orderText){
        selectByVisibleTextFromDropDown(sortByOptions, orderText);
    }

    public List<String> verifyProductOrder(){
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement productName : ListOfWebElements(productName)) {
            actualProductNames.add(productName.getText());
        }
        //System.out.println(actualProductNames);
        return actualProductNames;
    }

    public List<String> reverseProductOrder(List<String> actualProductNames){
        List<String> expectedProducts = new ArrayList<>(actualProductNames);
        expectedProducts.sort(Collections.reverseOrder());
        actualProductNames.sort(Collections.reverseOrder());
        return expectedProducts;
    }

    public void clickOnElement(By by){
        clickOnElement(by);
    }

    public void waitUntilVisibilityTag(By by){
        waitUntilVisibilityOfElementLocated(by, 30);
    }

    //Get text method
    public String getVerificationText(By by) {
        return getTextFromElement(by);
    }

    // Select Date
    public void selectDate(String date, String month, String year) throws InterruptedException {
        clickOnElement(calendarPath);
        while (true) {
            //String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            String monthYear = getTextFromElement(monthYearPath);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(daysPath);
            }
        }
        Thread.sleep(1000);

        // Select the date
        //List<WebElement> allDates = ListOfWebElements(allDates);
        for (WebElement dt : ListOfWebElements(allDates)) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    public void clearTextFromTag(By clearText){
        clearText(clearText);
    }


}
