package interactions.elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Orders extends BasicSetup {

//    public Orders(WebDriver driver) {
//        super(driver);
//    }

    public static void searchOrders() throws InterruptedException {

        //Click on main menu and search Orders in search box
        // after that click on the results "Orders"
        log.info("Search Orders");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().findElement(By.xpath(config.getProperty("Main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).sendKeys("Orders");
        getDriver().findElement(By.xpath(config.getProperty("List_Item_Orders"))).click();
        Thread.sleep(5000);
    }
    //change to list all Orders
    public static void changeListAccounts() throws InterruptedException {

        log.info("Change to all Orders");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box1"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box_All_Orders"))).click();
        Thread.sleep(5000);
    }


    //Create new Order
    public static void createNewOrder(String AccountN, String date) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));

        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(5000);
        System.out.println("Create new order");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("btn_Order_New"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_Order_New"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("account_name"))));
        getDriver().findElement(By.xpath(config.getProperty("account_name"))).sendKeys(AccountN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("account_name_B"))));
        getDriver().findElement(By.xpath(config.getProperty("account_name_B"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("order_start_date"))));
        getDriver().findElement(By.xpath(config.getProperty("order_start_date"))).sendKeys(date);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("btn_save"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_save"))).click();


        boolean found = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Order Products']")));
            found = true;
        } catch (TimeoutException eTO) {
            found = false;
        }

        softAssert.assertEquals(found,true , "Assertion for contact creation ");
        softAssert.assertAll();
        log.info("New order is created");

        System.out.println("Test is pass");
        Thread.sleep(5000);

    }
}
