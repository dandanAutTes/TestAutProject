package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;

//Write 1 automation scripts for menus and/or pages in SUT where you would handle alert popup
//Write 1 automation scripts for menus and/or pages in SUT where you would handle mouse hover
//Write 1 automation scripts for menus and/or pages in SUT where you would handle drag&drop items
public class Test_010 {

    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Print Alerts
        //BasicSetup.printAlertText();

        //Hover Mouse
        Products.hoverMouseOverElement();
        //Drag drop
        Products.dragAndDrop();
        //close app
        BasicSetup.closeD();

    }
}
