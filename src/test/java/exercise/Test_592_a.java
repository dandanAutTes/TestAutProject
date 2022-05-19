package exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_592_a {

    private static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {


        //open chrome browser -> go to url:xxx -> close chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://seavus.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("EU_OPIN_CANCEL")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).getAttribute("data-dark-logo"));
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).getSize());
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).getLocation());
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).getTagName());
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).getCssValue("box-sizing"));
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']/a")).isSelected());

        driver.close();

    }
}
