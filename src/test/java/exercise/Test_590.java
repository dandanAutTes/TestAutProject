package exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_590 {

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
        System.out.println( driver.getCurrentUrl());
        System.out.println(driver.getTitle());
       // System.out.println(driver.getPageSource());
        driver.close();

    }
}
