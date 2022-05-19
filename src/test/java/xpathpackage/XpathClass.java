package xpathpackage;

import interactions.elements.Pages.BasicSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathClass extends BasicSetup {


//    public XpathClass(WebDriver driver) {
//        super(driver);
//    }

    public static void xpathfinder() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//*[@role='button']//*[text()='Create New Product']")).click();
        Thread.sleep(5000);
        getDriver().findElements(By.tagName("iframe"));
        getDriver().switchTo().frame(0);
        //Product Name
        getDriver().findElement(By.xpath("(//input[@class='slds-input'])[1]")).sendKeys("Test 1");
        //Product Code
        getDriver().findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Test 2");
        Thread.sleep(2000);
        //Product Descripiton
        getDriver().findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("I am daniela and I am writing this");
        Thread.sleep(2000);
        //Choose Type
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[5]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='SIM Card']")).click();
        Thread.sleep(2000);
        //Click on Sub Type
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[6]")).click();
        Thread.sleep(2000);
        //scrol down
        WebElement Element = getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[4]"));
        Thread.sleep(2000);
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        //Choose Product Family
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[1]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='Multiplay']")).click();
        //Specification Type
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='Product']")).click();
        //Specification Sub Type
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[3]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='Simple']")).click();
        //Specification Status
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[4]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@class='slds-listbox__item']//*[@class='slds-media__body']/span[@title='Active']")).click();
        //Product Descripiton
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//textarea[@class='slds-textarea' and @rows='2'])[2]")).sendKeys("I am daniela and I am writing this for the second time");
        Thread.sleep(2000);
        //scrol down
        WebElement Element1 = getDriver().findElement(By.xpath("(//input[@class='vlocity-datepicker-input slds-input red'])[4]"));
        Thread.sleep(2000);
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element1);
        //Selling Start Date
        Thread.sleep(2000);
        //select Date
        getDriver().findElement(By.xpath("(//button[@title='Select a date'])[3]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[text()='2']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//button[@title='Select a date'])[3]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//button[@title='Select a date'])[4]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[text()='2']")).click();


        Thread.sleep(5000);

    }
}
