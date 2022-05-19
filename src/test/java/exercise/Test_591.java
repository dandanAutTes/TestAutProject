package exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_591 {

    private static ChromeDriver driver;

    public static void main(String[] args){


        //open chrome browser -> go to url:xxx -> close chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://seavus.com/");
        driver.manage().window().maximize();
        driver.close();

    }
}
