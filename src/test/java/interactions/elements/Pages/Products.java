package interactions.elements.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class Products extends BasicSetup {


//    public Products(WebDriver driver) {
//        super(driver);
//    }
//
    public static void searchProduct() throws InterruptedException {

        //Click on main menu and search Products in search box
        // after that click on the results "Products"
        log.info("Search Products");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().findElement(By.xpath(config.getProperty("Main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).click();
        getDriver().findElement(By.xpath(config.getProperty("src_box_main_menu"))).sendKeys("Products");
        getDriver().findElement(By.xpath(config.getProperty("List_Item_Products"))).click();

    }
    //change list to all products
    public static void changeListProduct() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_Products_box"))));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("src_Products_box_All"))));
        getDriver().findElement(By.xpath(config.getProperty("src_Products_box_All"))).click();
        String elem = getDriver().findElement(By.xpath("//*[@title='Create New Product']")).getText();
        softAssert.assertEquals(elem,"Create New Product", "Assertion for Products");
        softAssert.assertAll();
        log.info("Product search changed to all");
    }
    //open specific product
    public static void openProduct() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().navigate().to(config.getProperty("product_1"));

        System.out.println(getDriver().findElement(By.xpath(config.getProperty("product_1_text"))).getText());
        String elem = getDriver().findElement(By.xpath(config.getProperty("product_1_text"))).getText();
       // Thread.sleep(5000);
        softAssert.assertEquals(elem,"Test Product 124", "Assertion for products");
        softAssert.assertAll();
        log.info("Product is opened");
    }

    //create product
    public  static void createProduct(String name,String code) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("btn_Create_Product"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_Create_Product"))).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        getDriver().findElements(By.tagName("iframe"));
        getDriver().switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("product_name"))));
        getDriver().findElement(By.xpath(config.getProperty("product_name"))).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("product_code"))));
        getDriver().findElement(By.xpath(config.getProperty("product_code"))).sendKeys(code);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("btn_submit_Product"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_submit_Product"))).click();
        System.out.println("Inserted Product:" + name+" with Code:" + code);
        log.info("Inserted Product:" + name+" with Code:" + code);
        boolean found = false;
       try {
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Success']")));
            found = true;
        } catch (TimeoutException eTO) {
            found = false;
        }

        softAssert.assertEquals(found,true , "Assertion for product creation ");
        softAssert.assertAll();
        log.info("Product is created");

    }

    //here we select Product from the DD
    public static void selectProductDD(String name) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("btn_Create_Product"))));
        getDriver().findElement(By.xpath(config.getProperty("btn_Create_Product"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        getDriver().findElements(By.tagName("iframe"));
        getDriver().switchTo().frame(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='slds-input slds-combobox__input'])[1]")));
        //Choose Product Family
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='"+name+"']")));
        getDriver().findElement(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='"+name+"']")).click();
        System.out.println("PASS selectProductDD ");

    }
    //click on the checkbox
    public static void clickCheckBox() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Choose Product Family
        getDriver().findElement(By.xpath("(//span[@class='slds-checkbox_faux'])[2]")).click();
        System.out.println("PASS 2");

    }

    public static void hoverMouseOverElement() throws InterruptedException {

         //Click on main menu and search Products in search box
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement menu =getDriver().findElement(By.xpath(config.getProperty("Main_menu")));
        Actions action = new Actions(getDriver());
        action.moveToElement(menu).perform();
        System.out.println("Pass hover");
        Thread.sleep(5000);

        }

        public static void dragAndDrop() throws InterruptedException {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            getDriver().findElement(By.xpath("(//*[@data-aura-class='oneFavorites']/button)[2]")).click();
            getDriver().findElement(By.xpath("//*[text()='Edit Favorites']")).click();
            WebElement drag = getDriver().findElement(By.xpath("(//ol[@role='listbox']/li[@role='option']/span/div[@class='grabber'])[4]"));
            WebElement drop = getDriver().findElement(By.xpath("(//ol[@role='listbox']/li[@role='option']/span/div[@class='grabber'])[2]"));
            Actions action = new Actions(getDriver());
            action.dragAndDrop(drag,drop).perform();
            System.out.println("Pass drag drop");


        }
    }


