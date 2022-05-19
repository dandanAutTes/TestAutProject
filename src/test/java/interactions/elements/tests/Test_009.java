package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
//Write 1 automation scripts for menus and/or pages in SUT where you would handle frames
public class Test_009 {

    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search Contact
        Contacts.searchContacts();
        Contacts.changeListContacts();
        BasicSetup.waitRandom(5000);
        //Create the contact
        Contacts.switchFrame();
        //close app
        BasicSetup.closeD();

    }
}
