package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;

//Exercise 586
//2. Write 1 automation scripts for menus and/or pages in SUT where you would handle slider
//3. Write 1 automation scripts for menus and/or pages in SUT where you would handle right click elements
//4. Write 1 automation scripts for menus and/or pages in SUT where you would handle keyboard events
public class Test_011 {

    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Open Contact
        Contacts.searchContacts();
        Contacts.changeListContacts();
        //Exercise 586
        Contacts.sliderRightClickandEvent();

        //close app
        BasicSetup.closeD();

    }
}
