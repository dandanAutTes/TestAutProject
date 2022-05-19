package interactions.elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class VelocityProductConsole extends BasicSetup {

//    public VelocityProductConsole(WebDriver driver) {
//        super(driver);
//    }

    public static void selectDD() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //Thread.sleep(5000);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().navigate().to("https://seavus-testing-vlocity--vlocitysbx.lightning.force.com/lightning/n/vlocity_cmt__VlocityIndustryConsole");
       // Thread.sleep(5000);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().findElements(By.tagName("iframe"));
        getDriver().switchTo().frame(0);
       // Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@ng-if='obj.createRecord'])[1]")));
        //select the Product
        getDriver().findElement(By.xpath("(//span[@ng-if='obj.createRecord'])[1]")).click();
       // Thread.sleep(5000);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("PASS");

        getDriver().findElements(By.tagName("iframe"));
        getDriver().switchTo().frame(0);
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("objectType")));
        //select object type
        Select ObjType = new Select(getDriver().findElement(By.id("objectType")));
        System.out.println(ObjType.getAllSelectedOptions().size());
        //choose option
        ObjType.selectByVisibleText("DSLAM Resource Spec");
        System.out.println("PASS 1");
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fe_a347a0000003Zw2AAE")));


        //select the dd for Product Family, select third option
        Select projectFamily = new Select(getDriver().findElement(By.id("fe_a347a0000003Zw2AAE")));
        projectFamily.selectByIndex(2);
       // Thread.sleep(2000);

        //list all options in Product Family
         WebElement prodFamily= getDriver().findElement(By.id("fe_a347a0000003Zw2AAE"));
         List<WebElement> allOptions = prodFamily.findElements(By.tagName("option"));
        System.out.println(allOptions.size());
        for (int i=0; i<allOptions.size(); i++)
        {

            System.out.println( allOptions.get(i).getText());

        }


    }

}
