package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

//Find Product
public class Test_001 {


    public static void main(String[] args) throws InterruptedException {


        //This is a test case for opening product
        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search product
        Products.searchProduct();
        Products.changeListProduct();
        //open product
        Products.openProduct();
        //close app
        BasicSetup.closeD();


    }
}
