package interactions.elements.tests;

//Select

import interactions.elements.Pages.Accounts;
import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.VelocityProductConsole;
import org.openqa.selenium.WebDriver;

//2. Write 2 automation scripts for 2 different menus and/or pages in SUT where you would handle dropdown lists
public class Test_008 {


    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //test dropdown functionality
        VelocityProductConsole.selectDD();

        //close app
        BasicSetup.closeD();

    }
}
