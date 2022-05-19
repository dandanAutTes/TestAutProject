package csspackage;

import interactions.elements.Pages.BasicSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CSSClass extends BasicSetup {


//    public CSSClass(WebDriver driver) {
//        super(driver);
//    }

    public static void cssfinder() throws InterruptedException {

        Thread.sleep(2000);
       // getDriver().navigate().to("https://seavus-testing-vlocity--vlocitysbx.lightning.force.com/lightning/o/Contact/list?filterName=00B2X00000AEK0iUAH");

        getDriver().findElement(By.cssSelector("one-app-launcher-header.slds-icon-waffle_container > button.slds-button slds-show")).click();
        //Thread.sleep(2000);
       // getDriver().findElement(By.cssSelector("a[title='New'] > div[title='New']")).click();


    }
}
