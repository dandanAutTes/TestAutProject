package interactions.elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn extends BasicSetup {

    WebDriver driver;

//    public LogIn(WebDriver driver) {
//        super(driver);
//    }


    public static void LogSalesforce(String username, String password) throws InterruptedException {

        getDriver().findElement(By.id(config.getProperty("username"))).sendKeys(username);
        getDriver().findElement(By.id(config.getProperty("password"))).sendKeys(password);
        getDriver().findElement(By.id(config.getProperty("Login"))).click();
        Thread.sleep(5000);
    }

}
