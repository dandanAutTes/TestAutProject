package interactions.elements.tests;

import interactions.elements.Pages.*;

import javax.rmi.CORBA.Util;
import java.io.IOException;

//Exercise 586
//2. Write 1 automation scripts for menus and/or pages in SUT where you would handle slider
//3. Write 1 automation scripts for menus and/or pages in SUT where you would handle right click elements
//4. Write 1 automation scripts for menus and/or pages in SUT where you would handle keyboard events
public class SCreenshotEx {

    public static void main(String[] args) throws InterruptedException, IOException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        Thread.sleep(5000);
        Utils.takeScreenshot("scren1");
        Utils.writeToStep("scren1",0,1);
        System.out.println("PASS");
        //close app
        BasicSetup.closeD();

    }
}
