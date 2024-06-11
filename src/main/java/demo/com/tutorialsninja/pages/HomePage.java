package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    public By generateMenuLink(String menu){
        mouseHoverToElement(By.xpath("//a[normalize-space()='"+ menu +"']"));
        By menuLink = By.xpath("//a[normalize-space()='Show All"+ menu +"']");
        return menuLink;
    }

    public void clickOnMenu(String menuName){
        By menuLink = generateMenuLink(menuName);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        clickOnElement(menuLink);
    }

}
