package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Orders;

public class Test_005 {

    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search Contact
        Contacts.searchContacts();
        BasicSetup.waitRandom(5000);
        Contacts.changeListContacts();
        BasicSetup.waitRandom(5000);
        //Create the contact
        Contacts.createNewContact("Test db","Daniela B");
        //close app
        BasicSetup.closeD();

    }
}
