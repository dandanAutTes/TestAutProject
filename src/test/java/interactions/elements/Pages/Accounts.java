package interactions.elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Accounts extends BasicSetup {

//    public Accounts(WebDriver driver) {
//        super(driver);
//    }

    public static void searchAccounts()
    {

        //Click on main menu and search Accounts in search box
        // after that click on the results "Accounts"
        log.info("Search Accounts");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().findElement(By.xpath(config.getProperty("Main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).sendKeys("Accounts");
        getDriver().findElement(By.xpath(config.getProperty("List_Item_Accounts"))).click();

    }

    //change to list all Accounts
    public static void changeListAccounts() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_Products_box1"))));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box1"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_Products_box_All1"))));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box_All1"))).click();
        log.info("Change list for Accounts");

    }
    //Open Account
    public static void openAccount() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("account_src"))));
        getDriver().findElement(By.xpath(config.getProperty("account_src"))).click();
        getDriver().findElement(By.xpath(config.getProperty("account_src"))).sendKeys("Daniela B");
        getDriver().navigate().to(config.getProperty("account_1"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("account_1_text"))));
        String elem = getDriver().findElement(By.xpath(config.getProperty("account_1_text"))).getText();
        softAssert.assertEquals(elem,"Daniela B", "Assertion for Accounts");
        softAssert.assertAll();
        log.info("Open account Daniela B");

    }

    //here when we create new account , we switch between different options and the click on next button
    //then click on another check box
    public static void accountInteract() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")));
        getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='0127a000000ziGCAAY']/following-sibling::span[@class='slds-radio--faux']")));
        getDriver().findElement(By.xpath("//input[@value='0127a000000ziGCAAY']/following-sibling::span[@class='slds-radio--faux']")).click();
        System.out.println("PASS");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='0127a000000zj2nAAA']/following-sibling::span[@class='slds-radio--faux']")));
        getDriver().findElement(By.xpath("//input[@value='0127a000000zj2nAAA']/following-sibling::span[@class='slds-radio--faux']")).click();
        System.out.println("PASS 1");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']/span[text()='Next']")));
        getDriver().findElement(By.xpath("//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']/span[text()='Next']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='vlocity_cmt__EnableAutopay__c']")));
        WebElement Element = getDriver().findElement(By.xpath("//*[@name='vlocity_cmt__EnableAutopay__c']"));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        System.out.println("PASS 2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='vlocity_cmt__EnableAutopay__c']")));
        getDriver().findElement(By.xpath("//*[@name='vlocity_cmt__EnableAutopay__c']")).click();
        System.out.println("PASS 3");



    }


}
