package demo.com.tutorialsninja.browserfactory;

import demo.com.tutorialsninja.propertyreaders.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ManageBrowser {
    public static WebDriver driver;

    // create base url
    String baseUrl = PropertyReader.getInstance().getProperty("baseurl");

    int implicitWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitWait"));

    public void selectBrowser(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }

}
