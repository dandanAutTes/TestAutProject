package interactions.elements.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Contacts extends BasicSetup {

//    public Contacts(WebDriver driver) {
//        super(driver);
//    }

    public static void searchContacts() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        //Click on main menu and search Contacts in search box
        // after that click on the results "Contacts"
       // Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("Main_menu"))));
        getDriver().findElement(By.xpath(config.getProperty("Main_menu"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_box_main_menu"))));
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).sendKeys("Contacts");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("List_Item_Contacts"))));
        getDriver().findElement(By.xpath(config.getProperty("List_Item_Contacts"))).click();
    }

    //change to list all Contacts
    public static void changeListContacts() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_Products_box2"))));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box2"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_Products_box_All_Contacts"))));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box_All_Contacts"))).click();

    }

    //Create new contact
    public static void createNewContact(String LastN, String AccountN) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
       // Thread.sleep(5000);
        System.out.println("Hera I print something");
        System.out.println("Because the application is really fast");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("btn_Contact_New"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_Contact_New"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("last_name_contact"))));
        //populate last name
        getDriver().findElement(By.xpath(config.getProperty("last_name_contact"))).sendKeys(LastN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("account_name_contact"))));
        WebElement Element = getDriver().findElement(By.xpath(config.getProperty("account_name_contact")));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        //search account name
        Element.sendKeys(AccountN);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("account_name_contact_B"))));
        getDriver().findElement(By.xpath(config.getProperty("account_name_contact_B"))).click();
        //save the contact
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("btn_save_contact"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_save_contact"))).click();
       // Thread.sleep(5000);
        System.out.println("Test is pass");

        boolean found = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Contact \"Test db\" was created.']")));
            found = true;
        } catch (TimeoutException eTO) {
            found = false;
        }

        softAssert.assertEquals(found,true , "Assertion for contact creation ");
        softAssert.assertAll();
    }

    public static void switchFrame() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));


       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(config.getProperty("btn_Contact_New"))));
       getDriver().findElement(By.xpath(config.getProperty("btn_Contact_New"))).click();

        try{

            getDriver().findElements(By.tagName("iframe"));
            getDriver().switchTo().frame(0);
            System.out.println("Frame 0");
        }
        catch (Exception e)
        {
            System.out.println("No frame 0");
        }


    }

    //Create new contact
    public static void sliderRightClickandEvent() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        try{

            getDriver().findElements(By.tagName("iframe"));
            getDriver().switchTo().frame(0);
            System.out.println("Frame 0");
        }
        catch (Exception e)
        {
            System.out.println("No frame 0");
        }

        getDriver().findElement(By.xpath("//*[@title='List View Controls']")).click();
        getDriver().findElement(By.xpath("//*[@title='Display as Table']")).click();
        getDriver().findElement(By.xpath("//*[@title='List View Controls']")).click();
        getDriver().findElement(By.xpath("//*[@title='Display as Table']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(config.getProperty("btn_Contact_New"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_Contact_New"))).click();
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("account_name_contact"))));
        WebElement Element = getDriver().findElement(By.xpath(config.getProperty("account_name_contact")));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        System.out.println("Pass scroll");

       // Thread.sleep(5000);
        //Copy Last Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("last_name_contact"))));
        WebElement lastName=getDriver().findElement(By.xpath(config.getProperty("last_name_contact")));
        Actions actions = new Actions(getDriver());
        lastName.sendKeys("Test");

        // Copy the lastName
        actions.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
        actions.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();

        //Paste
        Element.click();
        actions.keyDown( Keys.CONTROL ).sendKeys( "V" ).keyUp( Keys.CONTROL ).build().perform();
        System.out.println("Copy paste pass");

        //right click
        actions.contextClick(lastName).perform();
        System.out.println("Test is pass");

    }


}
