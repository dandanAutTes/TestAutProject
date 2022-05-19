package interactions.elements.tests;

import com.sun.org.apache.xpath.internal.operations.Or;
import interactions.elements.Pages.*;

import java.io.IOException;

public class Test_004 {

    public static void main(String[] args) throws InterruptedException, IOException {

        //setup the properties and driver
        BasicSetup.setUp();
        Utils.takeScreenshot("scren1");
        Utils.writeToStep("scren1",0,1);
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        Utils.takeScreenshot("scren2");
        Utils.writeToStep("scren2",0,2);
        //Search Order
        Orders.searchOrders();
        Utils.takeScreenshot("scren3");
        Utils.writeToStep("scren3",0,3);
        //Change list to all
        Orders.changeListAccounts();
        Utils.takeScreenshot("scren4");
        Utils.writeToStep("scren4",0,4);
        //Create the order
        Orders.createNewOrder("Daniela B","27.1.2022");
        Utils.takeScreenshot("scren5");
        Utils.writeToStep("scren5",0,5);
        //close driver
        BasicSetup.closeD();

    }
}
