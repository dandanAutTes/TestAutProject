package interactions.elements.Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasicSetup {

   // public static  String browser = "chrome";
    private static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static Logger log = (Logger) LogManager.getLogger(BasicSetup.class);

//    public   BasicSetup(WebDriver driver)
//    {
//        this.driver = driver;
//    }

    //setup driver and config file
    public static void setUp()
    {

        //Loading properites in config variable
        if (driver == null) {
            try {
                fis = new FileInputStream("src/test/java/interactions/elements/properties/Config.properties");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                config.load(fis);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        //init webdriver
        if(config.getProperty("browser").equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-notifications");
            options.addArguments("window-size=1900x1600");
//        options.addArguments("--force-device-scale-factor=0.75");
//        // options.addArguments("headless");
            driver = new ChromeDriver(options);
            log.info("driver is config");

        }
        else if(config.getProperty("browser").equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        //redirect to site
        driver.get(config.getProperty("URL"));


    }

    public static void waitRandom(int number) throws InterruptedException {
        Thread.sleep(number);

    }

    public static void printAlertText() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(5000);
    }


    public static void closeD()
    {
        driver.close();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}
