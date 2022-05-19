package exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class Test_592 {

    public static  String browser = "chrome";
    private static WebDriver driver;

    public static void main(String[] args){


        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //open chrome browser -> go to url: xxxxx -> close chrome browser using webdriver manager
        driver.get("https://seavus.com/");
        driver.manage().window().maximize();
      //  System.out.println( driver.getCurrentUrl());
       // System.out.println(driver.getTitle());
        //System.out.println(driver.getWindowHandle());
        driver.navigate().to("https://time.mk/");
        //Set<String> handles = driver.getWindowHandles();
       // System.out.println(handles);
        List<WebElement> webel = driver.findElements(By.xpath("//*[@id='news_pane']/div[@class='cluster']"));
        for (WebElement ele: webel){

        System.out.println(ele.toString());}
        System.out.println("DONE");
       // System.out.println(driver.getPageSource());
        driver.close();

    }
}
