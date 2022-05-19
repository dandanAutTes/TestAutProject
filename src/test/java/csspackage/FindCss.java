package csspackage;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import xpathpackage.XpathClass;


public class FindCss {


    private static  WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
       // WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "src/test/drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.addPreference("dom.webnotifications.enabled", false);
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://test.salesforce.com/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("team.seavus@partner-prod.com.vlocitysbx");

        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("seavusQA123!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='Login']")).click();
        Thread.sleep(10000);
      //  driver.findElement(By.cssSelector("button[title='OK']")).click();
     //   Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.slds-icon-waffle")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Search apps and items...']")).sendKeys("Contacts");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[id='Contact']")).click();
       // Thread.sleep(5000);
       // driver.findElement(By.cssSelector("button[title='OK']")).click();
        Thread.sleep(5000);
       // driver.findElement(By.cssSelector("span[class='triggerLinkText selectedListView slds-page-header__title slds-truncate slds-p-right--xx-small uiOutputText']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li > a[title='New']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='Phone']")).sendKeys("07070707");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='MobilePhone']")).sendKeys("07070707");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("tests");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("tests");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='Title']")).sendKeys("DR");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("Email@email.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='AssistantPhone']")).sendKeys("08796969");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='Birthdate']")).sendKeys("6.2.2022");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='OtherPhone']")).sendKeys("0879696999");
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='country']")).sendKeys("MK");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[aria-label='Lead Source, --None--']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("lightning-base-combobox-item[data-value='Advertisement']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='Fax']")).sendKeys("83848495959");
        Thread.sleep(2000);


        driver.close();

    }
}
